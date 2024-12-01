package dev.inward.matrix;

import dev.inward.matrix.concept.matter.Matter;
import dev.inward.matrix.fact.datum.Complication;
import dev.inward.matrix.fact.datum.Envoy;

import java.lang.ref.SoftReference;
import java.nio.file.Watchable;
import java.util.Objects;
import java.util.concurrent.locks.StampedLock;
import java.util.function.Function;


/**
 *
 * @param <BEHAVIOR>
 * @param <W>
 * @param <OCCURRENCE>
 */
public class Policy<BEHAVIOR extends Function<C, OCCURRENCE>,PATH extends Comparable<PATH>,D extends Datum<D,E>,E extends Envoy<D,E>,C extends Complication<PATH,D,E,C,M,OCCURRENCE>,M extends Matter<M,OCCURRENCE>,OCCURRENCE extends Comparable<OCCURRENCE>> {

    protected final BEHAVIOR behavior;
    public Policy(BEHAVIOR behavior) {
        this.behavior = behavior;
    }

    public BEHAVIOR getBehavior() {
        return this.behavior;
    }

    public static class Singleton<BEHAVIOR extends Function<D, OCCURRENCE>,PATH extends Comparable<PATH>,D extends Datum<D,E>,E extends Envoy<D,E>,C extends Complication<PATH,D,E,C,M,OCCURRENCE>,M extends Matter<M,OCCURRENCE>,OCCURRENCE extends Comparable<OCCURRENCE>> extends Policy<BEHAVIOR,D,E,C,OCCURRENCE> {
        private final StampedLock gate = new StampedLock();

        public Singleton(BEHAVIOR behavior) {
            super(behavior);
        }

        public BEHAVIOR getBehavior() {
            long read
            try {

            }
            finally {
                gate.unlockWrite();
            }
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return this.getClass().getCanonicalName().compareTo(o.getClass().getCanonicalName()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.getClass().getCanonicalName());
    }

}
