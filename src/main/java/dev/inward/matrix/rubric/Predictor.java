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

public abstract class Predictor<Y extends Factory<Y,F,O,I,X,B,P,NP,PP>,D extends Datum<D,F,I,X,P,E>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P,NP,PP>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P,NP,PP>,P extends Progenitor<Y,F,O,I,X,B,P,NP,PP>,NP extends Notion<NP,I,X,PP>,PP extends Primogenitor<?,NP,?,I,X,?,PP>,E extends Envoy<Y,D,F,O,I,X,B,P,NP,PP,E>,C extends Criterion<Y,D,F,O,I,X,B,P,NP,PP,E,C,PRE>,PRE extends Predictor<Y,D,F,O,I,X,B,P,NP,PP,E,C,PRE>> implements Comparable<PRE>, Serializable {

    public abstract <COMP extends Complication<Y,D,F,O,I,X,B,P,NP,PP,E,?,COMP>> COMP registerCriterion(C criterion);

    public final static class Limited<Y extends Factory<Y,F,O,I,X,B,P,NP,PP>,D extends Datum<D,F,I,X,P,E>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P,NP,PP>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P,NP,PP>,P extends Progenitor<Y,F,O,I,X,B,P,NP,PP>,NP extends Notion<NP,I,X,PP>,PP extends Primogenitor<?,NP,?,I,X,?,PP>,E extends Envoy<Y,D,F,O,I,X,B,P,NP,PP,E>> extends Predictor<Y,D,F,O,I,X,B,P,NP,PP,E,Limiter<Y,D,F,O,I,X,B,P,NP,PP,E>,Limited<Y,D,F,O,I,X,B,P,NP,PP,E>> {


        @Override
        public <COMP extends Complication<Y, D, F, O, I, X, B, P, NP, PP, E, ?, COMP>> COMP registerCriterion(Limiter<Y, D, F, O, I, X, B, P, NP, PP, E> criterion) {
            return null;
        }

        @Override
        public int compareTo(Limited<Y, D, F, O, I, X, B, P, NP, PP, E> o) {
            return 0;
        }
    }
    public final static class Handled<Y extends Factory<Y,F,O,I,X,B,P,NP,PP>,D extends Datum<D,F,I,X,P,E>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P,NP,PP>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P,NP,PP>,P extends Progenitor<Y,F,O,I,X,B,P,NP,PP>,NP extends Notion<NP,I,X,PP>,PP extends Primogenitor<?,NP,?,I,X,?,PP>,E extends Envoy<Y,D,F,O,I,X,B,P,NP,PP,E>> extends Predictor<Y,D,F,O,I,X,B,P,NP,PP,E, Wrapped<Y,D,F,O,I,X,B,P,NP,PP,E>, Handled<Y,D,F,O,I,X,B,P,NP,PP,E>> {

        public Handled() {

        }
        @Override
        public int compareTo(Handled<Y,D,F,O,I,X,B,P,NP,PP,E> that) {
            return 0;
        }


        @Override
        public <COMP extends Complication<Y, D, F, O, I, X, B, P,NP,PP, E, ?, COMP>> COMP registerCriterion(Wrapped<Y, D, F, O, I, X, B, P,NP,PP, E> criterion) {
            return null;
        }
    }
    public final static class Visited<Y extends Factory<Y,F,O,I,X,B,P,NP,PP>,D extends Datum<D,F,I,X,P,E>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P,NP,PP>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P,NP,PP>,P extends Progenitor<Y,F,O,I,X,B,P,NP,PP>,NP extends Notion<NP,I,X,PP>,PP extends Primogenitor<?,NP,?,I,X,?,PP>,E extends Envoy<Y,D,F,O,I,X,B,P,NP,PP,E>,V extends DatumVisitor<Y,D,F,O,I,X,B,P,NP,PP,E>> extends Predictor<Y,D,F,O,I,X,B,P,NP,PP,E,Replacement<Y,D,F,O,I,X,B,P,NP,PP,E,V>, Visited<Y,D,F,O,I,X,B,P,NP,PP,E,V>> {

        public Visited() {

        }

        @Override
        public int compareTo(Visited<Y,D,F,O,I,X,B,P,NP,PP,E,V> o) {
            return 0;
        }


        @Override
        public <COMP extends Complication<Y, D, F, O, I, X, B, P,NP,PP, E, ?, COMP>> COMP registerCriterion(Replacement<Y, D, F, O, I, X, B, P,NP,PP, E, V> criterion) {
            return null;
        }
    }

    public final static class Time<Y extends Factory<Y,F,O,I,X,B,P,NP,PP>,D extends Datum<D,F,I,X,P,E>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P,NP,PP>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P,NP,PP>,P extends Progenitor<Y,F,O,I,X,B,P,NP,PP>,NP extends Notion<NP,I,X,PP>,PP extends Primogenitor<?,NP,?,I,X,?,PP>, E extends Envoy<Y, D, F, O, I, X, B, P,NP,PP,E>> extends Predictor<Y,D,F,O,I,X,B,P,NP,PP,E, Chronological<Y,D,F,O,I,X,B,P,NP,PP,E>,Time<Y,D,F,O,I,X,B,P,NP,PP,E>> {

        @Override
        public int compareTo(Time<Y,D,F,O,I,X,B,P,NP,PP,E> o) {
            return 0;
        }


        @Override
        public <COMP extends Complication<Y, D, F, O, I, X, B, P,NP,PP, E, ?, COMP>> COMP registerCriterion(Chronological<Y, D, F, O, I, X, B, P,NP,PP, E> criterion) {
            return null;
        }
    }
    public final static class Downer<Y extends Factory<Y,F,O,I,X,B,P,NP,PP>,D extends Datum<D,F,I,X,P,E>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P,NP,PP>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P,NP,PP>,P extends Progenitor<Y,F,O,I,X,B,P,NP,PP>,NP extends Notion<NP,I,X,PP>,PP extends Primogenitor<?,NP,?,I,X,?,PP>,E extends Envoy<Y,D,F,O,I,X,B,P,NP,PP,E>> extends Predictor<Y,D,F,O,I,X,B,P,NP,PP,E,OnCountdown<Y,D,F,O,I,X,B,P,NP,PP,E>, Downer<Y,D,F,O,I,X,B,P,NP,PP,E>> {

        @Override
        public int compareTo(Downer<Y,D,F,O,I,X,B,P,NP,PP,E> that) {
            return 0;
        }


        @Override
        public <COMP extends Complication<Y, D, F, O, I, X, B, P, NP, PP, E, ?, COMP>> COMP registerCriterion(OnCountdown<Y, D, F, O, I, X, B, P, NP, PP, E> criterion) {
            return null;
        }
    }
}
