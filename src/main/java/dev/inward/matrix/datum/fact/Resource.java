package dev.inward.matrix.datum.fact;

import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.Primogenitor;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.operational.Operational;
import dev.inward.matrix.rubric.Envoy;

import java.lang.ref.ReferenceQueue;

public class Resource<Y extends Factory<Y,F,O,I,X,B,P,NP,PP>,DATUM,D extends Datum<DATUM,D,F,I,X,P,NP,PP,E>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P,NP,PP>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P,NP,PP>,P extends Progenitor<Y,F,O,I,X,B,P,NP,PP>,NP extends Notion<NP,I,X,PP>,PP extends Primogenitor<?,NP,?,I,X,?,PP,?,?>,E extends Envoy<Y,DATUM,D,F,O,I,X,B,P,NP,PP,E>> {

    protected final ReferenceQueue<D> referenceQueue;

    public Resource(ReferenceQueue<D> referenceQueue) {
        this.referenceQueue = getReferenceQueue();
    }
    public Resource() {
        this.referenceQueue = new ReferenceQueue<>();
    }

    public ReferenceQueue<D> getReferenceQueue() {
        return this.referenceQueue;
    }
}
