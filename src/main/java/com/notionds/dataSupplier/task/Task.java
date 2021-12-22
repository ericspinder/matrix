package com.notionds.dataSupplier.task;

import dev.inward.matrix.Addressable;
import dev.inward.matrix.morph.Morph;

import java.util.function.Consumer;
import java.util.function.Supplier;

public abstract class Task<D extends Conditions, UM extends Addressable<UM>,C extends Consumer<Exception>, T extends Timer<S,C>> {

    private final String name;
    private final D conditions;
    private Morph<UM> morph;
    private boolean canceled = false;

    public Task(final String name, final boolean doAsCleanup, final S execution, final Consumer<Exception> handler) {
        this.name = name;
        this.doAsCleanup = doAsCleanup;
        this.execution = execution;
        this.handler = handler;
    }

    public boolean isDoAsCleanup() {
        return doAsCleanup;
    }

    public Supplier<Result<N,O,W,I>> execution() {
        return execution;
    }

    public Consumer<Exception> handler() {
        return handler;
    }
    public String name() {
        return this.name;
    }
}
