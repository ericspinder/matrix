package dev.inward.matrix.rubric;

import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Bus;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.datum.fact.Diplomat;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.Ambassador;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.operational.Operational;

import java.io.Serializable;

import static dev.inward.matrix.rubric.Criterion.*;

public abstract class Predictor<Y extends Factory<Y,F,O,I,X,B,P,N,NP>,DATUM,D extends Datum<DATUM,D,E>,E extends Envoy<DATUM,D,E,F,I,X,P,N,NP>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P,N,NP>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P,N,NP>,P extends Diplomat<Y,F,O,I,X,B,P,N,NP>,N extends Notion<N,I,X,NP>,NP extends Ambassador<?,N,?,I,X,?,NP,?,?>,CRIT extends Criterion<DATUM,D,E,F,I,X,P,N,NP,CRIT>,PRE extends Predictor<Y,DATUM,D,E,F,O,I,X,B,P,N,NP,CRIT,PRE>> implements Comparable<PRE>, Serializable {

    public abstract <COMP extends Complication<Y,DATUM,D,E,F,O,I,X,B,P,N,NP,?,COMP>> COMP registerCriterion(CRIT criterion);

    public final static class Limited<Y extends Factory<Y,F,O,I,X,B,P,N,NP>,DATUM,D extends Datum<DATUM,D,E>,E extends Envoy<DATUM,D,E,F,I,X,P,N,NP>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P,N,NP>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P,N,NP>,P extends Diplomat<Y,F,O,I,X,B,P,N,NP>,N extends Notion<N,I,X,NP>,NP extends Ambassador<?,N,?,I,X,?,NP,?,?>> extends Predictor<Y,DATUM,D,E,F,O,I,X,B,P,N,NP,Limiter<DATUM,D,E,F,I,X,P,N,NP>,Limited<Y,DATUM,D,E,F,O,I,X,B,P,N,NP>> {


        @Override
        public <COMP extends Complication<Y,DATUM,D,E,F,O,I,X,B,P,N,NP,?,COMP>> COMP registerCriterion(Limiter<DATUM,D,E,F,I,X,P,N,NP> criterion) {
            return null;
        }

        @Override
        public int compareTo(Limited<Y, DATUM,D,E,F,O,I,X,B,P,N,NP> o) {
            return 0;
        }

    }
    public final static class Handled<Y extends Factory<Y,F,O,I,X,B,P,N,NP>,DATUM,D extends Datum<DATUM,D,E>,E extends Envoy<DATUM,D,E,F,I,X,P,N,NP>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P,N,NP>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P,N,NP>,P extends Diplomat<Y,F,O,I,X,B,P,N,NP>,N extends Notion<N,I,X,NP>,NP extends Ambassador<?,N,?,I,X,?,NP,?,?>> extends Predictor<Y,DATUM,D,E,F,O,I,X,B,P,N,NP,Wrapped<DATUM,D,E,F,I,X,P,N,NP>,Handled<Y,DATUM,D,E,F,O,I,X,B,P,N,NP>> {

        public Handled() {

        }
        @Override
        public int compareTo(Handled<Y,DATUM,D,E,F,O,I,X,B,P,N,NP> that) {
            return 0;
        }


        @Override
        public <COMP extends Complication<Y,DATUM,D,E,F,O,I,X,B,P,N,NP,?,COMP>> COMP registerCriterion(Wrapped<DATUM,D,E,F,I,X,P,N,NP> criterion) {
            return null;
        }

    }
    public final static class Visited<Y extends Factory<Y,F,O,I,X,B,P,N,NP>,DATUM extends Comparable<DATUM> & Serializable,D extends Datum<DATUM,D,E>,E extends Envoy<DATUM,D,E,F,I,X,P,N,NP>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P,N,NP>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P,N,NP>,P extends Diplomat<Y,F,O,I,X,B,P,N,NP>,N extends Notion<N,I,X,NP>,NP extends Ambassador<?,N,?,I,X,?,NP,?,?>> extends Predictor<Y,DATUM,D,E,F,O,I,X,B,P,N,NP,Replacement<DATUM,D,E,F,I,X,P,N,NP>,Visited<Y,DATUM,D,E,F,O,I,X,B,P,N,NP>> {

        public Visited() {

        }

        @Override
        public int compareTo(Visited<Y,DATUM,D,E,F,O,I,X,B,P,N,NP> o) {
            return 0;
        }


        @Override
        public <COMP extends Complication<Y,DATUM,D,E,F,O,I,X,B,P,N,NP,?,COMP>> COMP registerCriterion(Replacement<DATUM,D,E,F,I,X,P,N,NP> criterion) {
            return null;
        }
    }

    public final static class Time<Y extends Factory<Y,F,O,I,X,B,P,N,NP>,DATUM,D extends Datum<DATUM,D,E>,E extends Envoy<DATUM,D,E,F,I,X,P,N,NP>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P,N,NP>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P,N,NP>,P extends Diplomat<Y,F,O,I,X,B,P,N,NP>,N extends Notion<N,I,X,NP>,NP extends Ambassador<?,N,?,I,X,?,NP,?,?>> extends Predictor<Y,DATUM,D,E,F,O,I,X,B,P,N,NP,Chronological<DATUM,D,E,F,I,X,P,N,NP>,Time<Y,DATUM,D,E,F,O,I,X,B,P,N,NP>> {

        @Override
        public int compareTo(Time<Y,DATUM,D,E,F,O,I,X,B,P,N,NP> o) {
            return 0;
        }


        @Override
        public <COMP extends Complication<Y,DATUM,D,E,F,O,I,X,B,P,N,NP, ?, COMP>> COMP registerCriterion(Chronological<DATUM,D,E,F,I,X,P,N,NP> criterion) {
            return null;
        }
    }
    public final static class Downer<Y extends Factory<Y,F,O,I,X,B,P,N,NP>,DATUM,D extends Datum<DATUM,D,E>,E extends Envoy<DATUM,D,E,F,I,X,P,N,NP>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P,N,NP>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P,N,NP>,P extends Diplomat<Y,F,O,I,X,B,P,N,NP>,N extends Notion<N,I,X,NP>,NP extends Ambassador<?,N,?,I,X,?,NP,?,?>> extends Predictor<Y,DATUM,D,E,F,O,I,X,B,P,N,NP,OnCountdown<DATUM,D,E,F,I,X,P,N,NP>,Downer<Y,DATUM,D,E,F,O,I,X,B,P,N,NP>> {

        @Override
        public int compareTo(Downer<Y,DATUM,D,E,F,O,I,X,B,P,N,NP> that) {
            return 0;
        }


        @Override
        public <COMP extends Complication<Y,DATUM,D,E,F,O,I,X,B,P,N,NP,?,COMP>> COMP registerCriterion(OnCountdown<DATUM,D,E,F,I,X,P,N,NP> criterion) {
            return null;
        }
    }
}
