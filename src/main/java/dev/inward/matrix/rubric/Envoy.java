package dev.inward.matrix.rubric;

import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;

import java.io.Serializable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.UUID;

public abstract class Envoy<DATUM,D extends Datum<DATUM,D,E,IC,XC>,E extends Envoy<DATUM,D,E,IC,XC>,IC extends Identity<IC,XC>,XC extends Context<XC>> extends SoftReference<DATUM> implements Comparable<E>, Serializable {

    public final UUID uuid = UUID.randomUUID();
    public static final class NoOp<DATUM,D extends Datum<DATUM,D,E,I,X>,E extends Envoy<DATUM,D,E,I,X>,I extends Identity<I,X>,X extends Context<X>> extends Envoy<DATUM,D,E,I,X> {

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

    @SuppressWarnings("unchecked")
    public D getDatum() {
        return (D) this.get();
    }
}