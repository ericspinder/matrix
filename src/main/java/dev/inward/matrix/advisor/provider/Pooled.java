package dev.inward.matrix.advisor.provider;

import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Bus;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.factory.Factory;
import dev.inward.matrix.datum.fact.Diplomat;
import dev.inward.matrix.operational.Operational;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.WeakHashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;


public abstract class Pooled<Y extends Factory<Y,F,O,I,X,B,P>,D extends Datum<Y,D,F,O,I,X,B,P>,F extends Fact<Y,F,O,I,X,B,P>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P>,P extends Diplomat<Y,F,O,I,X,B,P>,V extends Pooled<Y,D,F,O,I,X,B,P,V>> extends Provider<Y,D,F,O,I,X,B,P,V> {

    private final Executor executor;

    public Pooled(Executor executor) {
        super();
        this.executor = executor;
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
