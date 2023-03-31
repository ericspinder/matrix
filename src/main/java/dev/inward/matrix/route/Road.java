package dev.inward.matrix.route;

import dev.inward.matrix.engine.Zone;
import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.Representative;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.Context;
import dev.inward.matrix.fact.intialized.Book;
import dev.inward.matrix.phenomenon.Phenomenon;
import dev.inward.matrix.phenomenon.Tolerances;

import java.security.Permission;
import java.security.PermissionCollection;
import java.util.Enumeration;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Road<Z extends Zone<Z>,B extends Book> implements ThreadFactory {

    protected final Tolerances tolerances;
    public ConcurrentLinkedDeque<Driver<F,I,ID,X,?>> drivers;
    protected final AtomicBoolean running = new AtomicBoolean();
    protected final ConcurrentLinkedDeque<? super Phenomenon<?,T,?>> deque = new ConcurrentLinkedDeque();

    protected Road(Tolerances tolerances) {
        this.tolerances = tolerances;
    }

    public Tolerances getTolerances() {
        return tolerances;
    }

    public void shutdown() {

    }

    @Override
    @SuppressWarnings("all")
    public Driver newThread(Runnable r) {

        return null;
    }

}
