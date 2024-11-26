package dev.inward.matrix.fact.datum;

import dev.inward.matrix.*;
import dev.inward.matrix.fact.Addressed;

import java.lang.ref.SoftReference;

public abstract class Envoy<DATUM,D extends Datum<DATUM,D,E,PR>,E extends Envoy<DATUM,D,E,PR>,PR extends Representitive<?,?,?,?,PR,?>> extends Ware<DATUM,E,PR> implements Comparable<E> {

    protected final Datum.Resource<DATUM,D,E,PR> resource;
    protected final Long sequence;
    public Envoy(DATUM datum, Datum.Resource<DATUM,D,E,PR> resource) {
        super(datum, resource);
        this.resource = resource;
        this.sequence = resource.incrementAndGet();

    }

    protected void doIncrementFailure(D datum, Addressed.Resource<?,?,?,?,?,?> resource, MatrixException matrixException) {
        datum.getClass().getProtectionDomain();

    }

    @Override
    public int compareTo(E that) {
        return this.sequence.compareTo(that.sequence);
    }
}