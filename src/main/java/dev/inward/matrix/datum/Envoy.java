package dev.inward.matrix.datum;

import java.io.Serializable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.UUID;

public abstract class Envoy<DATUM, V extends Envoy<DATUM,V>> extends SoftReference<DATUM> implements Comparable<V>, Serializable {

    public final UUID uuid = UUID.randomUUID();
    public static final class NoOp<DATUM,D extends Datum<DATUM,D>,V extends Envoy<DATUM,V>> extends Envoy<DATUM,V> {

        public NoOp(DATUM datum, ReferenceQueue<DATUM> referenceQueue) {
            super(datum, referenceQueue);
        }

    }

    public Envoy(DATUM datum, ReferenceQueue<DATUM> referenceQueue) {
        super(datum, referenceQueue);
    }

    @Override
    public int compareTo(V that) {
        return this.uuid.compareTo(that.uuid);
    }

}