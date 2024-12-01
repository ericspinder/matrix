package dev.inward.matrix.fact.datum;

import dev.inward.matrix.*;
import dev.inward.matrix.fact.Addressed;

import java.lang.ref.SoftReference;

public abstract class Envoy<D extends Datum<D,E>,E extends Envoy<D,E>> extends Ware<D,E> implements Comparable<E> {


    public Envoy(D datum, Datum.Resource<D,E> resource) {
        super(datum, resource);


    }

    protected void doIncrementFailure(D datum, Addressed.Resource<?,?,?,?,?> resource, MatrixException matrixException) {
        datum.getClass().getProtectionDomain();

    }

    @Override
    public int compareTo(E that) {
        return this.sequence.compareTo(that.sequence);
    }
}