package dev.inward.matrix.datum;

import dev.inward.matrix.fact.Factory;

import dev.inward.matrix.rubric.Envoy;

import java.lang.ref.SoftReference;

public class Tracking<DATUM,D extends Datum<DATUM,D,E>,E extends Envoy<DATUM,D,E,?,?,?,?>> {

    protected final SoftReference<E> envoySoft;

    @SuppressWarnings("unchecked")
    public Tracking(D datum) {
        this.envoySoft = new SoftReference<>((E)((Factory)this.getClass().getClassLoader()).add(datum));
    }
    public E getEnvoy() {
        return this.envoySoft.get();
    }
}
