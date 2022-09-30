package dev.inward.matrix.datum.creation;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Bus;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.datum.fact.Diplomat;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.standard.time.InstantDatum;
import dev.inward.matrix.datum.fact.Operational;
import dev.inward.matrix.rubric.Envoy;

import java.lang.ref.ReferenceQueue;

public class Timed<Y extends Factory<Y,F,O,I,X,B,P,?,?,?,?,?>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P>,P extends Diplomat<Y,F,O,I,X,B,P>> extends Envoy<Y, InstantDatum,Creation<F,I,X,P>,F,O,I,X,B,P, Timed<Y,F,O,I,X,B,P>> {

    public Timed(Creation<F, I, X, P, NP, PP, Timed<Y, F, O, I, X, B, P, NP, PP>> datum, ReferenceQueue<Creation<F, I, X, P, NP, PP, Timed<Y, F, O, I, X, B, P, NP, PP>>> referenceQueue, P progenitor) {
        super(datum, referenceQueue, progenitor);
    }

    @Override
    public int compareTo(Timed<Y, F, O, I, X, B, P, NP, PP> o) {
        return 0;
    }
}
