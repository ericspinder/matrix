package dev.inward.matrix.rubric;

import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Diplomat;
import dev.inward.matrix.datum.fact.notion.concept.Context;

import java.io.Serializable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.UUID;

public abstract class Envoy<DATUM,D extends Datum<DATUM,D,E,F,I,X,P>,E extends Envoy<DATUM,D,E,F,I,X,P>,F extends Fact<F,I,X,P>,I extends Identity<I,X>,X extends Context<X>,P extends Diplomat<?,F,?,I,X,?,P>> extends SoftReference<DATUM> implements Comparable<E>, Serializable {

    protected final UUID uuid = UUID.randomUUID();
    public static final class NoOp<DATUM,D extends Datum<DATUM,D,E,F,I,X,P>,E extends Envoy<DATUM,D,E,F,I,X,P>,F extends Fact<F,I,X,P>,I extends Identity<I,X>,X extends Context<X>,P extends Diplomat<?,F,?,I,X,?,P>> extends Envoy<DATUM,D,E,F,I,X,P> {

        public NoOp(DATUM datum, ReferenceQueue<DATUM> referenceQueue) {
            super(datum, referenceQueue);
        }
    }

    public Envoy(DATUM datum, ReferenceQueue<DATUM> referenceQueue) {
        super(datum, referenceQueue);
    }

    @Override
    public int compareTo(E that) {
        return this.uuid.compareTo(that.uuid);
    }
}