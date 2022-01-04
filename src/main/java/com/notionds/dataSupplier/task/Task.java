package com.notionds.dataSupplier.task;

import java.io.Serializable;
import java.util.concurrent.CompletableFuture;

public abstract class Task<C extends Conditions, R extends Result<Q>,Q extends Request> implements Comparable<Task<C,R,Q>>, Serializable {

    private final String name;
    private final C conditions;
    private final CompletableFuture<R> load;

    public Task(final String name, C conditions, CompletableFuture<R> load) {
        this.name = name;
        this.conditions = conditions;
        this.load = load;
    }
    public abstract boolean enqueue(Q request);

    public String name() {
        return this.name;
    }
    public C getConditions() {
        return this.conditions;
    }
    public CompletableFuture<R> getLoad() {
        return this.load;
    }
}
