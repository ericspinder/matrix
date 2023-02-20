package dev.inward.matrix.route;

import dev.inward.matrix.fact.Bus;
import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.Operational;
import dev.inward.matrix.fact.Representative;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.matter.Matter;
import dev.inward.matrix.fact.Context;
import dev.inward.matrix.phenomenon.Phenomenon;
import dev.inward.matrix.phenomenon.Tolerances;

import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.spi.AsynchronousChannelProvider;
import java.util.concurrent.*;

public class Route<F extends Fact<F,I,X>,I extends Identity<I,X>,X extends Context<X>,O extends Operational<F,I,X,O>,B extends Bus<F,I,X,R,B,M,T,P>,R extends Representative<F,I,X,R,?,?>,M extends Matter<M,I,X>,T extends Tolerances<M,T>,P extends Phenomenon<M,T,P>> extends AsynchronousChannelGroup {

    protected final Road<F,I,X,R,T> road;
    protected Route(Road<F,I,X,R,T> road) {
        this(road,null);
    }
    protected Route(Road<F,I,X,R,T> road,AsynchronousChannelProvider provider) {
        super(provider);
        this.road = road;
    }

    @Override
    public void shutdown() {
        this.road.shutdown();
    }

    @Override
    public void shutdownNow() {
        this.road.shutdownNow();
    }

    @Override
    public boolean isShutdown() {
        return this.road.isShutdown();
    }

    @Override
    public boolean isTerminated() {
        return this.road.isTerminated();
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return this.road.awaitTermination(timeout,unit);
    }

}
