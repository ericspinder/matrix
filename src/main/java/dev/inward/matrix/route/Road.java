package dev.inward.matrix.route;

import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.Representative;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.Context;
import dev.inward.matrix.phenomenon.Phenomenon;
import dev.inward.matrix.phenomenon.Tolerances;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Road<F extends Fact<F,I,ID,VERSION,X>,I extends Identity<I,ID,VERSION,X>,ID extends Comparable<ID>,VERSION extends Comparable<VERSION>,X extends Context<VERSION,X>,R extends Representative<F,I,X,R,?,?>> implements ThreadFactory {


    protected final Tolerances tolerances;
    public ConcurrentLinkedDeque<Worker<F,I,X,R>> workers;
    protected final AtomicBoolean running = new AtomicBoolean();
    protected final ConcurrentLinkedDeque<? super Phenomenon<?,T,?>> deque = new ConcurrentLinkedDeque();

    protected Road(Tolerances tolerances) {
        this.tolerances = tolerances;
    }

    public Tolerances getTolerances() {
        return tolerances;
    }

    @Override
    public void shutdown() {

    }

    @Override
    @SuppressWarnings("all")
    public Thread newThread(Runnable r) {


    }
}
