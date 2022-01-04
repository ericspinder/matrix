package com.notionds.dataSupplier.provider;

import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.context.Context;
import com.notionds.dataSupplier.exceptions.Recommendation;
import com.notionds.dataSupplier.operational.Operational;
import com.notionds.dataSupplier.task.Task;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.ref.SoftReference;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.StampedLock;

import static com.notionds.dataSupplier.operational.IntegerOption.*;

public abstract class Provider<D extends Datum<D,O,C,X>,O extends Operational<D,O>,C extends Container<D,O,C,X,?>,X extends Context<D,O,C,X>> {

    private static final Logger log = LogManager.getLogger();
    private StampedLock gate = new StampedLock();
    public Provider() {
    }

    protected abstract C newContainer();

    protected abstract D create();


    public abstract U getWrappedReady();

    public boolean addNotion(D wrapper, boolean returned) {
        if (returned) {
            this.loanedNotions.remove(wrapper);
            if (!(wrapper.getContainer().getBridge().returnToPool(wrapper))) {
                log.error("ConnectionId=" + ((Datum)added).getContainer().containerId + " was not able to reuse, will close");
                (wrapper.getContainer().closeDelegate());
                return false;
            }
        }
        if (evalForSpaceInPool() && connectionQueue.add(added)) {
            ((Datum)added).getContainer().currentSituation = Situation.Provider;
            log.debug("ConnectionId=" + ((Datum)added).getContainer().containerId + " was added/re-added to Notion provider, queue_size=" + connectionQueue.size());
            return true;
        } else {
            log.error("ConnectionId=" + ((Datum)added).getContainer().containerId + " was not able to add Notion provider, queue_size=" + connectionQueue.size());
            ((Datum)added).getContainer().closeDelegate(((Datum)added));
            return false;
        }
    }

    public void addNotionFutures(Supplier<Container<DELEGATE,O,?>> newNotionSupplier, int notionsToAdd) {
        if (notionsToAdd >= options.getInteger(Minimum_Replenishment.getI18n())) {
            for (int i = 0; i < notionsToAdd; i++) {
                CompletableFuture.supplyAsync(() -> this.addNotion(newNotionSupplier.get(), false), connectionExecutor);
            }
        }
        else {
            log.debug("No need to fill notionsToAdd=" + notionsToAdd);
        }
    }
    public boolean addNotionNow(Supplier<Container<DELEGATE,O,?>> newNotionSupplier) {
        return this.addNotion(newNotionSupplier.get(), false);
    }

    /**
     * Drains and closes the current connection provider and marks them all loaned to be close when no longer in use, rather than returned to the provider.
     */
    public void drainAllCurrentConnections() {
        List<Datum> drain = new ArrayList<>();
        this.connectionQueue.drainTo(drain);
        this.loanedNotions.keySet().stream().forEach((Datum loaned) -> loaned.getContainer().currentSituation = Situation.Empty);
        drain.forEach((Datum artifactI) -> artifactI.getContainer().closeDelegate(artifactI));

    }
    public Receipt<DATUM,O, U, C> add(final U wrapper, final Task[] tasks) {
        SoftReference softReference = new SoftReference(wrapper, this.globalReferenceQueue);
        boolean isDoCleanup = false;
        Instant lowestTime = null;
        Map<Task, Instant> taskInstantMap = new HashMap<>();
        for (Task task : tasks) {
            if (task.isDoAsCleanup()) isDoCleanup = true;
            if (task.startTime() != null) {
                taskInstantMap.put(task, task.startTime());
                if (lowestTime == null) {
                    lowestTime = task.startTime();
                } else {
                    if (task.startTime().isBefore(lowestTime)) lowestTime = task.startTime();
                }
            }
        }
        if (isDoCleanup)
            return new Receipt<>(wrapper, globalReferenceQueue, taskInstantMap, lowestTime);
        else
            return new Receipt<>(wrapper,taskInstantMap,lowestTime);
    }

}
