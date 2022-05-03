package dev.inward.matrix.rubric;

import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Bus;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.datum.fact.Progenitor;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.Primogenitor;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.operational.Operational;

import java.io.Serializable;

import static dev.inward.matrix.rubric.Criterion.*;

public abstract class Predictor<Y extends Factory<Y,F,O,I,X,B,P,NP,PP>,DATUM,D extends Datum<DATUM,D,F,I,X,P,NP,PP,E>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P,NP,PP>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P,NP,PP>,P extends Progenitor<Y,F,O,I,X,B,P,NP,PP>,NP extends Notion<NP,I,X,PP>,PP extends Primogenitor<?,NP,?,I,X,?,PP>,E extends Envoy<Y,DATUM,D,F,O,I,X,B,P,NP,PP,E>,C extends Criterion<DATUM,D,F,I,X,P,NP,PP,E,C>,PRE extends Predictor<Y,DATUM,D,F,O,I,X,B,P,NP,PP,E,C,PRE>> implements Comparable<PRE>, Serializable {

    public abstract <COMP extends Complication<Y,DATUM,D,F,O,I,X,B,P,NP,PP,E,?,COMP>> COMP registerCriterion(C criterion);

    public final static class Limited<Y extends Factory<Y,F,O,I,X,B,P,NP,PP>,DATUM,D extends Datum<DATUM,D,F,I,X,P,NP,PP,E>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P,NP,PP>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P,NP,PP>,P extends Progenitor<Y,F,O,I,X,B,P,NP,PP>,NP extends Notion<NP,I,X,PP>,PP extends Primogenitor<?,NP,?,I,X,?,PP>,E extends Envoy<Y,DATUM,D,F,O,I,X,B,P,NP,PP,E>> extends Predictor<Y,DATUM,D,F,O,I,X,B,P,NP,PP,E,Limiter<DATUM,D,F,I,X,P,NP,PP,E>,Limited<Y,DATUM,D,F,O,I,X,B,P,NP,PP,E>> {


        @Override
        public <COMP extends Complication<Y,DATUM,D, F, O, I, X, B, P, NP, PP, E, ?, COMP>> COMP registerCriterion(Limiter<DATUM,D,F,I,X,P,NP,PP,E> criterion) {
            return null;
        }

        @Override
        public int compareTo(Limited<Y, DATUM,D, F, O, I, X, B, P, NP, PP, E> o) {
            return 0;
        }
    }
    public final static class Handled<Y extends Factory<Y,F,O,I,X,B,P,NP,PP>,DATUM,D extends Datum<DATUM,D,F,I,X,P,NP,PP,E>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P,NP,PP>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P,NP,PP>,P extends Progenitor<Y,F,O,I,X,B,P,NP,PP>,NP extends Notion<NP,I,X,PP>,PP extends Primogenitor<?,NP,?,I,X,?,PP>,E extends Envoy<Y,DATUM,D,F,O,I,X,B,P,NP,PP,E>> extends Predictor<Y,DATUM,D,F,O,I,X,B,P,NP,PP,E,Wrapped<DATUM,D,F,I,X,P,NP,PP,E>, Handled<Y,DATUM,D,F,O,I,X,B,P,NP,PP,E>> {

        public Handled() {

        }
        @Override
        public int compareTo(Handled<Y,DATUM,D,F,O,I,X,B,P,NP,PP,E> that) {
            return 0;
        }


        @Override
        public <COMP extends Complication<Y,DATUM,D, F, O, I, X, B, P,NP,PP, E, ?, COMP>> COMP registerCriterion(Wrapped<DATUM,D,F,I,X,P,NP,PP,E> criterion) {
            return null;
        }
    }
    public final static class Visited<Y extends Factory<Y,F,O,I,X,B,P,NP,PP>,DATUM extends Comparable<DATUM> & Serializable,D extends Datum<DATUM,D,F,I,X,P,NP,PP,E>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P,NP,PP>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P,NP,PP>,P extends Progenitor<Y,F,O,I,X,B,P,NP,PP>,NP extends Notion<NP,I,X,PP>,PP extends Primogenitor<?,NP,?,I,X,?,PP>,E extends Envoy<Y,DATUM,D,F,O,I,X,B,P,NP,PP,E>> extends Predictor<Y,DATUM,D,F,O,I,X,B,P,NP,PP,E,Replacement<DATUM,D,F,I,X,P,NP,PP,E>,Visited<Y,DATUM,D,F,O,I,X,B,P,NP,PP,E>> {

        public Visited() {

        }

        @Override
        public int compareTo(Visited<Y,DATUM,D,F,O,I,X,B,P,NP,PP,E> o) {
            return 0;
        }


        @Override
        public <COMP extends Complication<Y,DATUM,D, F, O, I, X, B, P,NP,PP, E, ?, COMP>> COMP registerCriterion(Replacement<DATUM,D,F,I,X,P,NP,PP,E> criterion) {
            return null;
        }
    }

    public final static class Time<Y extends Factory<Y,F,O,I,X,B,P,NP,PP>,DATUM,D extends Datum<DATUM,D,F,I,X,P,NP,PP,E>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P,NP,PP>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P,NP,PP>,P extends Progenitor<Y,F,O,I,X,B,P,NP,PP>,NP extends Notion<NP,I,X,PP>,PP extends Primogenitor<?,NP,?,I,X,?,PP>, E extends Envoy<Y,DATUM, D, F, O, I, X, B, P,NP,PP,E>> extends Predictor<Y,DATUM,D,F,O,I,X,B,P,NP,PP,E, Chronological<DATUM,D,F,I,X,P,NP,PP,E>,Time<Y,DATUM,D,F,O,I,X,B,P,NP,PP,E>> {

        @Override
        public int compareTo(Time<Y,DATUM,D,F,O,I,X,B,P,NP,PP,E> o) {
            return 0;
        }


        @Override
        public <COMP extends Complication<Y,DATUM,D, F, O, I, X, B, P,NP,PP, E, ?, COMP>> COMP registerCriterion(Chronological<DATUM,D,F,I,X,P,NP,PP,E> criterion) {
            return null;
        }
    }
    public final static class Downer<Y extends Factory<Y,F,O,I,X,B,P,NP,PP>,DATUM,D extends Datum<DATUM,D,F,I,X,P,NP,PP,E>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P,NP,PP>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P,NP,PP>,P extends Progenitor<Y,F,O,I,X,B,P,NP,PP>,NP extends Notion<NP,I,X,PP>,PP extends Primogenitor<?,NP,?,I,X,?,PP>,E extends Envoy<Y,DATUM,D,F,O,I,X,B,P,NP,PP,E>> extends Predictor<Y,DATUM,D,F,O,I,X,B,P,NP,PP,E,OnCountdown<DATUM,D,F,I,X,P,NP,PP,E>, Downer<Y,DATUM,D,F,O,I,X,B,P,NP,PP,E>> {

        @Override
        public int compareTo(Downer<Y,DATUM,D,F,O,I,X,B,P,NP,PP,E> that) {
            return 0;
        }


        @Override
        public <COMP extends Complication<Y,DATUM,D, F, O, I, X, B, P, NP, PP, E, ?, COMP>> COMP registerCriterion(OnCountdown<DATUM,D,F,I,X,P,NP,PP,E> criterion) {
            return null;
        }
    }
}
