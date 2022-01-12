package com.notionds.dataSupplier.provider;

import com.notionds.dataSupplier.datum.Bus;
import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.NotionStartupException;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.operational.Operational;

import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.WeakHashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

import static com.notionds.dataSupplier.operational.DurationOption.ConnectionMaxLifetime;

public class Pooled<DATUM extends Comparable<DATUM> & Serializable, O extends Operational<DATUM, O>, B extends Bus<DATUM, O, B, C, U,?,?,?>, C extends Container<DATUM, O, B, C, U>, U extends Datum<U,O, C,?>> extends Provider<DATUM, O, B, C, U> {

    private final Executor executor;

    public Pooled(B bus, Executor executor) {
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

    public U loanPooledMember(Supplier<Container<DATUM, O, B, C, U>> newConnectionArtifactSupplier) {
        if (evalForSpaceInPool()) {
            addNotionFutures(newConnectionArtifactSupplier, minActiveConnections - connectionQueue.size());
        }
        try {
            wrapper = (D) connectionQueue.poll(connection_retrieve_millis, connection_retrieve_time_unit);
            loanedNotions.put(wrapper, Instant.now());
            return wrapper;
        } catch (ClassCastException cce) {
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
