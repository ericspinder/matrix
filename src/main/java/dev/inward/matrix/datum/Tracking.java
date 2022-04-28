package dev.inward.matrix.datum;

import dev.inward.matrix.datum.fact.Bus;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.datum.fact.Progenitor;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.Primogenitor;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.operational.Operational;
import dev.inward.matrix.rubric.Envoy;

public class Tracking<Y extends Factory<Y,F,O,I,X,B,P,NP,PP>,D extends Datum<D,F,I,X,P,E>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P,NP,PP>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P,NP,PP>,P extends Progenitor<Y,F,O,I,X,B,P,NP,PP>,NP extends Notion<NP,I,X,PP>,PP extends Primogenitor<?,NP,?,I,X,?,PP>,E extends Envoy<Y,D,F,O,I,X,B,P,NP,PP,E>> {

    protected final E envoy;
    @SuppressWarnings("unchecked")
    public Tracking(D datum) {
        this.envoy = ((Y) this.getClass().getClassLoader()).add(datum);
    }
    public E getEnvoy() {
        return this.envoy;
    }
}
