package dev.inward.matrix.resources;

import dev.inward.matrix.Resource;
import dev.inward.matrix.fact.datum.Ware;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.WeakHashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class Pool<DATUM,D extends Datum<DATUM,D,V>, V extends Ware<DATUM,D,V>> extends Resource<DATUM,D,V> {

    /**
     * Default timeout when loaned out
     */
    private Duration timeoutOnLoan_default;
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
     * Holds the ready DATUM objects, wrapped as Datum and initialized
     */
    private final BlockingQueue<D> connectionQueue = new LinkedBlockingQueue<>();
    /**
     * The loaned Notions are held weakly and will drop out when garbage collected. They will be sent to a
     * referenceQueue in the Cleanup class when ready
     */
    private final WeakHashMap<D, Instant> loanedNotions = new WeakHashMap<>();

    public D loanPooledMember() {

        throw new UnsupportedOperationException("fix");

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

    public int getMaxAllowed() {
        return maxTotalNotionsAllowed;
    }

    public void setMaxAllowed(int maxTotalNotionsAllowed) {
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

}
