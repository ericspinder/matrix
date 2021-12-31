package com.notionds.dataSupplier.provider;

import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.Bus;
import com.notionds.dataSupplier.NotionStartupException;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.exceptions.Recommendation;
import com.notionds.dataSupplier.notion.Notion;
import com.notionds.dataSupplier.options.Options;
import com.notionds.dataSupplier.task.Task;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Supplier;

import static com.notionds.dataSupplier.options.DurationOption.ConnectionMaxLifetime;
import static com.notionds.dataSupplier.options.IntegerOption.*;

public abstract class Provider<DATUM extends Comparable<DATUM> & Serializable,O extends Options<DATUM,O,D>,C extends Container<DATUM,O,C,D,B>,D extends Datum<DATUM,O,C,D,B>, B extends Bus<DATUM,O,C,D,B,?,?,?>> {

    public static class PooledProvider<DATUM extends Comparable<DATUM> & Serializable,O extends Options<DATUM,O>, B extends Bus<DATUM,O,B,C,U,?,?,?,?>, C extends Container<DATUM,O,B,C,U>,U extends Datum<DATUM,O,B,C,U>> extends Provider<DATUM,O,B,C,U> {

        private final Executor executor;

        public PooledProvider(B bus, Executor executor) {
            super(bus);
            this.executor = executor;
            this.maxConnectionLifetime = bus.getOperational().getDuration(ConnectionMaxLifetime.getI18n());
        }
        /**
         * Default timeout when loaned out
         */
        private Duration timeoutOnLoan_default;
        /**
         * This is the length of time a client will wait for a notion to be created before erring out
         * The Duration is split into TimeUnits for efficient use in the poll method
         */
        private long connection_retrieve_millis;
        private final TimeUnit connection_retrieve_time_unit = TimeUnit.MILLISECONDS;
        /**
         * Max number of connections allowed, this is not a hard limit
         */
        private int maxTotalNotionsAllowed;
        /**
         * The number of connections the system will attempt to keep in absence of breaching the maximum
         */
        private int minActiveConnections;
        /**
         * The max time a Notion will be allowed to stay active.
         */
        private Duration maxConnectionLifetime;
        /**
         * Holds the ready connection objects, wrapped and active
         */
        private final BlockingQueue<DATUM> connectionQueue = new LinkedBlockingQueue<>();
        /**
         * The loaned Notions are held weakly and will drop out when garbage collected. They will be sent to a
         * referenceQueue in the Cleanup class when ready
         */
        private final WeakHashMap<DATUM, Instant> loanedNotions = new WeakHashMap<>();

        public U loanPooledMember(Supplier<Container<DATUM,O,B,C,U>> newConnectionArtifactSupplier) {
            if (evalForSpaceInPool()) {
                addNotionFutures(newConnectionArtifactSupplier,minActiveConnections - connectionQueue.size());
            }
            try {
                 wrapper = (D) connectionQueue.poll(connection_retrieve_millis, connection_retrieve_time_unit);
                loanedNotions.put(wrapper, Instant.now());
                return wrapper;
            }
            catch (ClassCastException cce) {
                cce.printStackTrace();
                throw new NotionStartupException(NotionStartupException.Type.BadCastToGeneric, this.getClass());
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new NotionStartupException(NotionStartupException.Type.WAITED_TOO_LONG_FOR_CONNECTION, this.getClass());
            }
        }
        public Duration getTimeoutOnLoan_default() {
            return timeoutOnLoan_default;
        }

        public void setTimeoutOnLoan_default(Duration timeoutOnLoan_default) {
            this.timeoutOnLoan_default = timeoutOnLoan_default;
        }

        public Duration getConnection_retrieveTimeout() {
            return Duration.of(connection_retrieve_millis, ChronoUnit.MILLIS);
        }

        public void setConnection_retrieveTimeout(Duration connection_retrieveTimeout) {
            this.connection_retrieve_time_unit.toMillis(connection_retrieveTimeout.toMillis());
        }

        public int getMaxTotalNotionsAllowed() {
            return maxTotalNotionsAllowed;
        }

        public void setMaxTotalNotionsAllowed(int maxTotalNotionsAllowed) {
            this.maxTotalNotionsAllowed = maxTotalNotionsAllowed;
        }

        public int getMinActiveConnections() {
            return minActiveConnections;
        }

        public void setMinActiveConnections(int minActiveConnections) {
            this.minActiveConnections = minActiveConnections;
        }
        private boolean evalForSpaceInPool() {
            return loanedNotions.size() + connectionQueue.size() < maxTotalNotionsAllowed;
        }

        @Override
        public U getWrappedReady() {
            return null;
        }
    }
    public static class BulkFreshProvider<DATUM extends Comparable<DATUM> & Serializable,O extends Options<DATUM,O>, B extends Bus<DATUM,O,B,C,U,?,?,?,?>, C extends Container<DATUM,O,B,C,U>,U extends Datum<DATUM,O,B,C,U>> extends Provider<DATUM,O,B,C,U> {

        public BulkFreshProvider(O options, B bus) {
            super(bus);
        }

        @Override
        public U getWrappedReady() {
            return null;
        }
    }

    private static final Logger log = LogManager.getLogger();
    private final B bus;
    public Provider(B bus) {
        this.bus = bus;
    }

    @SuppressWarnings("unchecked")
    private C newContainer() {
        return this.connectionPool.populateConnectionContainer();
    }


    protected populateConnectionContainer() {
        Container<,?,?> container = bus.getNewContainer(this.options, this, t, D artifactWrapper);
        try {
            return container.wrap(bus.getMemberSupplier(), Connection.class, null);
        } catch (Exception e) {
            r.handleException(e, null);
            return null;
        }
    }

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
    public void removeFromCleanup(U wrapper) {
        this.timeoutCleanup.remove(wrapper);
        wrapper.getContainer().getReceipt().clear();
    }
    public void checkForRecyclables() {
        Receipt<DATUM,O, U, C> receipt = (Receipt<DATUM,O, U, C>) this.globalReferenceQueue.poll();
        U wrapper = receipt.get();
    }
    public void doFailover(Recommendation recommendation) {

    }



}
