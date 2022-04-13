package dev.inward.matrix.path;

import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Bus;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.datum.fact.Progenitor;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Gathering;
import dev.inward.matrix.operational.Operational;
import dev.inward.matrix.rubric.Complication;
import dev.inward.matrix.rubric.Criterion;
import dev.inward.matrix.rubric.Envoy;
import dev.inward.matrix.rubric.Predictor;

public class Limit<Y extends Factory<Y,F,O,I,X,B,P>,D extends Datum<D,F,I,X,P,E>,F extends Fact<F,I,X,P,?,?,?>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<F,B>,P extends Progenitor<Y,F,O,I,X,B,P>,E extends Envoy<Y,D,F,O,I,X,B,P,E>> extends Complication<Y,D,F,O,I,X,B,P,E,Criterion.Limiter<Y,D,F,O,I,X,B,P,E>, Predictor.Limited<Y,D,F,O,I,X,B,P,E>,Limit<Y,D,F,O,I,X,B,P,E>> implements Gathering.Ledger<Y,D,F,O,I,X,B,P,E> {

    public Limit(Predictor.Limited<Y,D,F,O,I,X,B,P,E> predictor, Criterion.Limiter<Y,D,F,O,I,X,B,P,E> criterion) {
        super(predictor, criterion);
    }


    @Override
    public int compareTo(Limit<Y, D, F, O, I, X, B, P, E> o) {
        return 0;
    }

    @Override
    public boolean forRemoval(Envoy<Y, D, F, O, I, X, B, P, E> envoy) {
        return false;
    }
}
