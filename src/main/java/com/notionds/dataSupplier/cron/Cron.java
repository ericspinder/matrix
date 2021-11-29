package com.notionds.dataSupplier.cron;

import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.NotionStartupException;
import com.notionds.dataSupplier.delegation.Wrapper;
import com.notionds.dataSupplier.operational.Operational;
import com.notionds.dataSupplier.operational.task.Task;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.time.Duration;
import java.time.Instant;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

import static com.notionds.dataSupplier.operational.DurationOption.ConnectionMaxLifetime;

public class Cron<N,O extends Operational<N,W,T>,W extends Wrapper<N,O,T>,T extends Container<N,O,W>> implements Runnable {

    private static final Logger log = LogManager.getLogger(Cron.class);

    protected boolean doCleanup = true;
    private final ReferenceQueue<W> globalReferenceQueue = new ReferenceQueue<>();
    private final Map<W, Instant> timeoutCleanup = Collections.synchronizedMap(new WeakHashMap<>());

    /**
     * The max time a Notion will be allowed to stay active.
     */
    private Duration maxConnectionLifetime;

    public Cron(O options) {
        this.maxConnectionLifetime = options.getDuration(ConnectionMaxLifetime.getI18n());
    }

    public Receipt<N,O,W,T> add(final W wrapper, final Task[] tasks) {
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
    public void removeFromCleanup(W wrapper) {
        this.timeoutCleanup.remove(wrapper);
        wrapper.getContainer().getReceipt().clear();
    }
    public void checkForRecyclables() {
        Receipt<N,O,W,T> receipt = (Receipt<N,O,W,T>) this.globalReferenceQueue.poll();
        W wrapper = receipt.get();
    }

    /**
     * Patrol for ConnectionContainer timeouts
     */
    protected void patrolForNewTimeouts() {
        for (Map.Entry<W, Instant> returnedWrapped: timeoutCleanup.entrySet()) {
            Instant expireTime = returnedWrapped.getValue();
            if (expireTime != null && expireTime.isAfter(Instant.now())) {
                if (returnedWrapped.getKey() instanceof Container) {
                    W wrapped = returnedWrapped.getKey();
                    wrapped.getContainer().closeDelegate();
                    log.error("Timeout for ConnectionId=" + wrapped.getContainer().containerId);
                }
                else {
                    Container.DoDelegateClose(returnedWrapped.getKey());
                    throw new NotionStartupException(NotionStartupException.Type.Timeout_On_Non_Containerized_Notion, null);
                }
            }
        }
    }



    public void run() {
//        try {
            while (doCleanup) {
                checkForRecyclables();
                patrolForNewTimeouts();
            }
//        }
//        catch (InterruptedException ie) {
//            return;
//        }
    }
    public Duration getMaxConnectionLifetime() {
        return maxConnectionLifetime;
    }

    public void setMaxConnectionLifetime(Duration maxConnectionLifetime) {
        this.maxConnectionLifetime = maxConnectionLifetime;
    }
}
