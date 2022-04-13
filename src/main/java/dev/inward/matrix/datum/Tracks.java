package dev.inward.matrix.datum;

import dev.inward.matrix.datum.fact.Bus;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.matter.sanction.Sanction;
import dev.inward.matrix.matter.warrant.why.Why;
import dev.inward.matrix.operational.Operational;
import dev.inward.matrix.datum.fact.Progenitor;
import dev.inward.matrix.rubric.Complication;
import dev.inward.matrix.rubric.Criterion;
import dev.inward.matrix.rubric.Envoy;
import dev.inward.matrix.rubric.Predictor;

import java.lang.invoke.MethodHandle;
import java.util.Map;

public class Tracks<Y extends Factory<Y,F,O,I,X,B,P>,D extends Datum<D,F,I,X,P,E>,F extends Fact<F,I,X,P,?,?,?,?>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<F,B>,P extends Progenitor<Y,F,O,I,X,B,P>,E extends Envoy<Y,D,F,O,I,X,B,P,E>>
        extends Predictor<Y,D,F,O,I,X,B,P,E, Tracks.Track<Y,D,F,O,I,X,B,P,E>,Tracks<Y,D,F,O,I,X,B,P,E>> {

    private Map<String,Track<Y,D,F,O,I,X,B,P,E>> tracks;
    public Tracks(D datum) {
        this.tracks = ((Y) this.getClass().getClassLoader()).add(datum);
    }

    @Override
    public <COMP extends Complication<Y, D, F, O, I, X, B, P, E, Track<Y, D, F, O, I, X, B, P, E>, Tracks<Y, D, F, O, I, X, B, P, E>, COMP>> COMP registerCriterion(Track<Y, D, F, O, I, X, B, P, E> criterion) {
        return null;
    }

    @Override
    public int compareTo(Tracks<Y, D, F, O, I, X, B, P, E> o) {
        return 0;
    }


    public static abstract class Track<Y extends Factory<Y,F,O,I,X,B,P>,D extends Datum<D,F,I,X,P,E>,F extends Fact<F,I,X,P,?,?,?,?>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<F,B>,P extends Progenitor<Y,F,O,I,X,B,P>,E extends Envoy<Y,D,F,O,I,X,B,P,E>> extends Criterion<Y,D,F,O,I,X,B,P,E,Track<Y,D,F,O,I,X,B,P,E>,Tracks<Y,D,F,O,I,X,B,P,E>> {


        public Track(MethodHandle methodHandle) {
            this.methodHandle = methodHandle;
        }
        public <S extends Sanction<?, I, X, ?>> boolean before(Why<I, X, S, ?> why, D datum) {
            return true;
        }

        public abstract <S extends Sanction<?, I, X, ?>> void after(Why<I, X, S, ?> why, D datum);
        public abstract <S extends Sanction<?, I, X, ?>> void afterFail(Why<I, X, S, ?> why, D datum);
    }
    public Map<String,Track<Y,D,F,O,I,X,B,P,E>> getTracks() {
        return this.tracks;
    }
}
