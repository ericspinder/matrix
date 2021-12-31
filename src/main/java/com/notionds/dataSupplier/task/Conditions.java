package com.notionds.dataSupplier.task;

import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.options.Options;

import java.time.Duration;
import java.time.Instant;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Conditions {

    // timer
    // on cleanup
    // on getter or setter (method)
    // on method exception

    public static class Countdown<N,O extends Options<N,W,T>,W extends Datum<N,O,T>,T extends Container<N,O,W>> extends Timer<N,O,W,T> {
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
    public static class SpecificTime<N,O extends Options<N,W,T>,W extends Datum<N,O,T>,T extends Container<N,O,W>> extends Task<N,O,W,T> {
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
    public static class CleanupOnly<N,O extends Options<N,W,T>,W extends Datum<N,O,T>,T extends Container<N,O,W>> extends Task<N,O,W,T> {

        public CleanupOnly(final String name, final Supplier<Result<N,O,W,T>> execution, final Consumer<Exception> handler) {
            super(name, true,execution,handler);
        }

        @Override
        public Instant startTime() {
            return null;
        }
    }
}
