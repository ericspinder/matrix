package dev.inward.matrix.fact.datum.creation;

import dev.inward.matrix.fact.*;
import dev.inward.matrix.fact.datum.Envoy;
import dev.inward.matrix.fact.datum.time.InstantDatum;
import dev.inward.matrix.Context;

import java.lang.ref.ReferenceQueue;

public class Timed<Y extends Factory<Y,F,O,I,X,B,P,?,?,?,?,?>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P>,P extends Model<Y,F,O,I,X,B,P>> extends Envoy<Y, InstantDatum,Creation<F,I,X,P>,F,O,I,X,B,P, Timed<Y,F,O,I,X,B,P>> {

    public Timed(Creation<F, I, X, P, NP, PP, Timed<Y, F, O, I, X, B, P, NP, PP>> datum, ReferenceQueue<Creation<F, I, X, P, NP, PP, Timed<Y, F, O, I, X, B, P, NP, PP>>> referenceQueue, P progenitor) {
        super(datum, referenceQueue, progenitor);
    }

    @Override
    public int compareTo(Timed<Y, F, O, I, X, B, P, NP, PP> o) {
        return 0;
    }
}
