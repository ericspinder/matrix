package com.notionds.dataSupplier.operational.task;

import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.delegation.Wrapper;
import com.notionds.dataSupplier.operational.Operational;

import java.time.Duration;
import java.time.Instant;
import java.util.function.Consumer;
import java.util.function.Supplier;

public abstract class Task<N,O extends Operational<N,W,I>,W extends Wrapper<N,O,I>,I extends Container<N,O,W>,R extends Result<N,O,W,I>, S extends Supplier<R>,C extends Consumer<Exception>, T extends Timer<S,C>> {

    private final String name;
    private final T timer;
    private final boolean doAsCleanup;
    private final S execution;
    private final Consumer<Exception> handler;
    private boolean canceled = false;

    public Task(final String name, final boolean doAsCleanup, final S execution, final Consumer<Exception> handler) {
        this.name = name;
        this.doAsCleanup = doAsCleanup;
        this.execution = execution;
        this.handler = handler;
    }

    public abstract Instant startTime();

    public boolean isDoAsCleanup() {
        return doAsCleanup;
    }

    public Supplier<Result<N,O,W, I>> execution() {
        return execution;
    }

    public Consumer<Exception> handler() {
        return handler;
    }
    public String name() {
        return this.name;
    }
    public boolean isCanceled() { return this.canceled; }

    public static class Countdown<N,O extends Operational<N,W,T>,W extends Wrapper<N,O,T>,T extends Container<N,O,W>> extends Task<N,O,W,T> {
        private final Duration fromStart;

        public Countdown(final String name, final boolean registerForCleanup, final Supplier<Result<N,O,W,T>> execution, final Consumer<Exception> handler, final Duration fromStart) {
            super(name, registerForCleanup, execution, handler);
            this.fromStart = fromStart;
        }

        public Duration timeFromNow() {
            return fromStart;
        }

        @Override
        public Instant startTime() {
            return Instant.now().plus(fromStart);
        }
    }
    public static class SpecificTime<N,O extends Operational<N,W,T>,W extends Wrapper<N,O,T>,T extends Container<N,O,W>> extends Task<N,O,W,T> {
        private final Instant instant;

        public SpecificTime(final String name, final boolean registerForCleanup, final Supplier<Result<N,O,W,T>> execution, final Consumer<Exception> handler, final Instant instant) {
            super(name,registerForCleanup,execution,handler);
            this.instant = instant;
        }

        public Instant instant() {
            return this.instant;
        }

        @Override
        public Instant startTime() {
            return this.instant;
        }
    }
    public static class CleanupOnly<N,O extends Operational<N,W,T>,W extends Wrapper<N,O,T>,T extends Container<N,O,W>> extends Task<N,O,W,T> {

        public CleanupOnly(final String name, final Supplier<Result<N,O,W,T>> execution, final Consumer<Exception> handler) {
            super(name, true,execution,handler);
        }

        @Override
        public Instant startTime() {
            return null;
        }
    }
}
