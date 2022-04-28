package dev.inward.matrix.datum.creation;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Bus;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.datum.fact.Progenitor;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.Primogenitor;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.operational.Operational;
import dev.inward.matrix.rubric.Envoy;

import java.lang.ref.ReferenceQueue;

public class Prime<Y extends Factory<Y,F,O,I,X,B,P,NP,PP>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P,NP,PP>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P,NP,PP>,P extends Progenitor<Y,F,O,I,X,B,P,NP,PP>,NP extends Notion<NP,I,X,PP>,PP extends Primogenitor<?,NP,?,I,X,?,PP>> extends Envoy<Y,Creation<F,I,X,P,Prime<Y,F,O,I,X,B,P,NP,PP>>,F,O,I,X,B,P,NP,PP,Prime<Y,F,O,I,X,B,P,NP,PP>> {

    public Prime(Creation<F,I,X,P,Prime<Y,F,O,I,X,B,P,NP,PP>> datum, ReferenceQueue<Creation<F,I,X,P,Prime<Y,F,O,I,X,B,P,NP,PP>>> referenceQueue,P progenitor) {
        super(datum, referenceQueue, progenitor);
    }

    @Override
    public int compareTo(Prime<Y,F,O,I,X,B,P,NP,PP> that) {
        return (this.getDatum().;
    }
}
