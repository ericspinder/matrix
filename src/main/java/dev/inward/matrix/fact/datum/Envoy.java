package dev.inward.matrix.fact.datum;

import dev.inward.matrix.resources.Resource;

import java.io.Serializable;
import java.lang.invoke.CallSite;
import java.lang.ref.SoftReference;
import java.util.UUID;

public abstract class Envoy<DATUM, V extends Envoy<DATUM,V>> extends SoftReference<DATUM> implements Comparable<V>, Serializable {

    protected final UUID uuid;
    protected CallSite[] callSites;
    public static class NoOp<DATUM,V extends Envoy<DATUM,V>> extends Envoy<DATUM,V> {

        public NoOp(DATUM datum, Resource<DATUM> referenceQueue, UUID uuid) {
            super(datum, referenceQueue, uuid);
        }
    }

    public Envoy(DATUM datum, Resource<DATUM> resource, UUID uuid) {
        super(datum, resource);
        this.uuid = uuid;
        if (resource.increment()) {

        }
    }

    @Override
    public int compareTo(V that) {
        DATUM datum  = this.get();
        if (datum != null) {
            DATUM thatDatum = that.get();
            if (thatDatum != null && datum instanceof Comparable && thatDatum instanceof Comparable) {
                return ((Comparable<DATUM>)datum).compareTo(thatDatum);
            }
        }
        return this.uuid.compareTo(that.uuid);
    }
}