package dev.inward.matrix.datum;

import dev.inward.matrix.factory.Factory;

import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.rubric.Envoy;

public class Tracking<DATUM,D extends Datum<DATUM,D,E,I,X>,E extends Envoy<DATUM,D,E,I,X>,I extends Identity<I,X>,X extends Context<X>> {

    protected final E envoy;

    @SuppressWarnings("unchecked")
    public Tracking(D datum) {
        this.envoy = (E)((Factory)this.getClass().getClassLoader()).add(datum);
    }
    public E getEnvoy() {
        return this.envoy;
    }
}
