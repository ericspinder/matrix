package dev.inward.matrix.datum;

import dev.inward.matrix.datum.fact.Factory;

public class Tracking<DATUM,D extends Datum<DATUM,D>> {

    protected final Envoy<DATUM,D,?> envoy;

    @SuppressWarnings("unchecked")
    public Tracking(D datum) {
        this.envoy = (Envoy<DATUM,D,?>)((Factory)this.getClass().getClassLoader()).getEngine().buildEnvoy(datum);
    }
    public Envoy<DATUM,D,?> getEnvoy() {
        return this.envoy;
    }
}
