package com.notionds.dataSupplier.task;

import dev.inward.matrix.crud.Container;
import com.notionds.dataSupplier.subject.Subject;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.meta.Meta_I;
import com.notionds.dataSupplier.operational.Operational;

import java.time.Duration;
import java.time.Instant;
import java.util.function.Consumer;
import java.util.function.Supplier;

public abstract class Conditions<D extends Datum<D,?,?,?>,C extends Conditions<D,I,S,Q,C>> extends Subject<W,R> {

    public enum When implements Meta_I<When> {
        OnInitialization("On Initialization","");
        private final String label;
        private final String description;
        When(String label, String description) {
            this.label = label;
            this.description = description;
        }
        @Override
        public String getLabel() {
            return null;
        }

        @Override
        public String getI18n() {
            return this.getDatumClass();
        }

        @Override
        public String getDescription() {
            return null;
        }
    }

    // timer
    // on cleanup
    // on getter or setter (method)
    // on method exception

    public static class Countdown<N,O extends Operational<N,W,T>,W extends Datum<N,O,T>,T extends Container<N,O,W>> extends Conditions<N,O,W,T> {
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
    public static class SpecificTime<N,O extends Operational<N,W,T>,W extends Datum<N,O,T>,T extends Container<N,O,W>> extends Conditions<N,O,W,T> {
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
    public static class CleanupOnly<N,O extends Operational<N,W,T>,W extends Datum<N,O,T>,T extends Container<N,O,W>> extends Conditions<N,O,W,T> {

        public CleanupOnly(final String name, final Supplier<Result<N,O,W,T>> execution, final Consumer<Exception> handler) {
            super(name, true,execution,handler);
        }

        @Override
        public Instant startTime() {
            return null;
        }
    }
}
