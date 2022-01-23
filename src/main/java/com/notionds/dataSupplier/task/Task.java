package com.notionds.dataSupplier.task;

import com.notionds.dataSupplier.container.Container;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.subject.sanction.Sanction;
import com.notionds.dataSupplier.operational.Operational;

import java.io.Serializable;
import java.util.concurrent.CompletableFuture;

public abstract class Task<D extends Datum<?,D,O,C,I>,O extends Operational<D,O>,C extends Container<D,O,C,I>,I extends Id<?,I,?>,S extends Sanction<D,?,?,?>,C extends Conditions<D,O,S,C,R,Q>,R extends Result<Q>,Q extends Request> implements Comparable<Task<C,R,Q>>, Serializable {

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
