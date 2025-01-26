package dev.inward;

import java.io.Serializable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.net.URL;
import java.util.UUID;

public abstract class Envoy<DATUM,D extends Datum<DATUM,D,V>, V extends Envoy<DATUM,D,V>> extends SoftReference<DATUM> implements Comparable<V>, Serializable {

    public final UUID uuid = UUID.randomUUID();
    public static final class NoOp<DATUM,D extends Datum<DATUM,D,V>,V extends Envoy<DATUM,D,V>> extends Envoy<DATUM,D,V> {

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

    @SuppressWarnings("unchecked")
    public D getDatum() {
        return (D) this.get();
    }

}