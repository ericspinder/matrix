package dev.inward.matrix;

public abstract class Envoy<D extends Datum<D,E,A>, E extends Envoy<D,E,A>, A extends DatumAttributes<D,E,A>> extends Ware<D,E,A> implements Comparable<E> {


    public Envoy(D datum, DatumResource<D,E,A> resource) {
        super(datum, resource);
    }

    protected void doIncrementFailure(D datum, MatrixException matrixException) {
        datum.getClass().getProtectionDomain();

    }

    @Override
    public int compareTo(E that) {
        return this.sequence.compareTo(that.sequence);
    }
}