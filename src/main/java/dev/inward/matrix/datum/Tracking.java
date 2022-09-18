package dev.inward.matrix.datum;

import dev.inward.matrix.factory.Factory;

import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.rubric.Envoy;

public class Tracking<DATUM,D extends Datum<DATUM,D,E>,E extends Envoy<DATUM,D,E>> {

    protected final E envoy;

    @SuppressWarnings("unchecked")
    public Tracking(D datum) {
        this.envoy = (E)((Factory)this.getClass().getClassLoader()).add(datum);
    }
    public E getEnvoy() {
        return this.envoy;
    }
}
