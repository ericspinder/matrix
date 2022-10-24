package crud.rubric;

import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Envoy;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Bus;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.datum.fact.Diplomat;
import dev.inward.matrix.datum.fact.notion.concept.*;
import dev.inward.matrix.datum.fact.Operational;
import dev.inward.matrix.engine.Criterion;

import java.io.Serializable;

import static dev.inward.matrix.engine.Criterion.*;

public abstract class Predictor<Y extends Factory<Y,F,O,I,X,B,P,FAB,C,T,V,M>,DATUM,D extends Datum<DATUM,D,E,F,I,X,P>,E extends Envoy<DATUM,D,E,F,I,X,P>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P>,P extends Diplomat<Y,F,O,I,X,B,P>,FAB extends Fabrication<FAB,C,T,V,M>,C extends Concept<C,M>,T extends Effect<FAB,C,T,V,M>,V extends Volume<FAB,C,T,V,M>,M extends Mortal<FAB,C,T,V,M>,CRIT extends Criterion<DATUM,F,I,X>,PRE extends Predictor<Y,DATUM,D,E,F,O,I,X,B,P,FAB,C,T,V,M,CRIT,PRE>> implements Comparable<PRE>, Serializable {

    public abstract <COMP extends Complication<Y,DATUM,D,E,F,O,I,X,B,P,FAB,C,T,V,M,COMP>> COMP registerCriterion(CRIT criterion);

    public final static class Limited<Y extends Factory<Y,F,O,I,X,B,P,FAB,C,T,V,M>,DATUM,D extends Datum<DATUM,D,E,F,I,X,P>,E extends Envoy<DATUM,D,E,F,I,X,P>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P>,P extends Diplomat<Y,F,O,I,X,B,P>,FAB extends Fabrication<FAB,C,T,V,M>,C extends Concept<C,M>,T extends Effect<FAB,C,T,V,M>,V extends Volume<FAB,C,T,V,M>,M extends Mortal<FAB,C,T,V,M>> extends Predictor<Y,DATUM,D,E,F,O,I,X,B,P,FAB,C,T,V,M,Limiter<DATUM,F,I,X>,Limited<Y,DATUM,D,E,F,O,I,X,B,P,FAB,C,T,V,M>> {

        @Override
        public <COMP extends Complication<Y, DATUM, D, E, F, O, I, X, B, P, FAB, C, T, V, M, COMP>> COMP registerCriterion(Limiter<DATUM, F, I, X> criterion) {
            return null;
        }

        @Override
        public int compareTo(Limited<Y, DATUM, D, E, F, O, I, X, B, P, FAB, C, T, V, M> o) {
            return 0;
        }
    }
    public final static class Handled<Y extends Factory<Y,F,O,I,X,B,P,FAB,C,T,V,M>,DATUM,D extends Datum<DATUM,D,E,F,I,X,P>,E extends Envoy<DATUM,D,E,F,I,X,P>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P>,P extends Diplomat<Y,F,O,I,X,B,P>,FAB extends Fabrication<FAB,C,T,V,M>,C extends Concept<C,M>,T extends Effect<FAB,C,T,V,M>,V extends Volume<FAB,C,T,V,M>,M extends Mortal<FAB,C,T,V,M>> extends Predictor<Y,DATUM,D,E,F,O,I,X,B,P,FAB,C,T,V,M,Wrapped<DATUM,F,I,X>,Handled<Y,DATUM,D,E,F,O,I,X,B,P,FAB,C,T,V,M>> {


        @Override
        public <COMP extends Complication<Y, DATUM, D, E, F, O, I, X, B, P, FAB, C, T, V, M, COMP>> COMP registerCriterion(Wrapped<DATUM, F, I, X> criterion) {
            return null;
        }

        @Override
        public int compareTo(Handled<Y, DATUM, D, E, F, O, I, X, B, P, FAB, C, T, V, M> o) {
            return 0;
        }
    }
    public final static class Visited<Y extends Factory<Y,F,O,I,X,B,P,FAB,C,T,V,M>,DATUM,D extends Datum<DATUM,D,E,F,I,X,P>,E extends Envoy<DATUM,D,E,F,I,X,P>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P>,P extends Diplomat<Y,F,O,I,X,B,P>,FAB extends Fabrication<FAB,C,T,V,M>,C extends Concept<C,M>,T extends Effect<FAB,C,T,V,M>,V extends Volume<FAB,C,T,V,M>,M extends Mortal<FAB,C,T,V,M>> extends Predictor<Y,DATUM,D,E,F,O,I,X,B,P,FAB,C,T,V,M,Replacement<DATUM,F,I,X>,Visited<Y,DATUM,D,E,F,O,I,X,B,P,FAB,C,T,V,M>> {

        @Override
        public <COMP extends Complication<Y, DATUM, D, E, F, O, I, X, B, P, FAB, C, T, V, M, COMP>> COMP registerCriterion(Replacement<DATUM, F, I, X> criterion) {
            return null;
        }

        @Override
        public int compareTo(Visited<Y, DATUM, D, E, F, O, I, X, B, P, FAB, C, T, V, M> o) {
            return 0;
        }
    }

    public final static class Time<Y extends Factory<Y,F,O,I,X,B,P,FAB,C,T,V,M>,DATUM,D extends Datum<DATUM,D,E,F,I,X,P>,E extends Envoy<DATUM,D,E,F,I,X,P>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P>,P extends Diplomat<Y,F,O,I,X,B,P>,FAB extends Fabrication<FAB,C,T,V,M>,C extends Concept<C,M>,T extends Effect<FAB,C,T,V,M>,V extends Volume<FAB,C,T,V,M>,M extends Mortal<FAB,C,T,V,M>> extends Predictor<Y,DATUM,D,E,F,O,I,X,B,P,FAB,C,T,V,M,Chronological<DATUM,F,I,X>,Time<Y,DATUM,D,E,F,O,I,X,B,P,FAB,C,T,V,M>> {

        @Override
        public <COMP extends Complication<Y, DATUM, D, E, F, O, I, X, B, P, FAB, C, T, V, M, COMP>> COMP registerCriterion(Chronological<DATUM, F, I, X> criterion) {
            return null;
        }

        @Override
        public int compareTo(Time<Y, DATUM, D, E, F, O, I, X, B, P, FAB, C, T, V, M> o) {
            return 0;
        }
    }
    public final static class Downer<Y extends Factory<Y,F,O,I,X,B,P,FAB,C,T,V,M>,DATUM,D extends Datum<DATUM,D,E,F,I,X,P>,E extends Envoy<DATUM,D,E,F,I,X,P>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P>,P extends Diplomat<Y,F,O,I,X,B,P>,FAB extends Fabrication<FAB,C,T,V,M>,C extends Concept<C,M>,T extends Effect<FAB,C,T,V,M>,V extends Volume<FAB,C,T,V,M>,M extends Mortal<FAB,C,T,V,M>> extends Predictor<Y,DATUM,D,E,F,O,I,X,B,P,FAB,C,T,V,M,OnCountdown<DATUM,F,I,X>,Downer<Y,DATUM,D,E,F,O,I,X,B,P,FAB,C,T,V,M>> {

        @Override
        public <COMP extends Complication<Y, DATUM, D, E, F, O, I, X, B, P, FAB, C, T, V, M, COMP>> COMP registerCriterion(OnCountdown<DATUM, F, I, X> criterion) {
            return null;
        }

        @Override
        public int compareTo(Downer<Y, DATUM, D, E, F, O, I, X, B, P, FAB, C, T, V, M> o) {
            return 0;
        }
    }
}
