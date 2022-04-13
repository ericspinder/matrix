package dev.inward.matrix.rubric;

import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Bus;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.operational.Operational;
import dev.inward.matrix.datum.fact.Progenitor;

import java.io.Serializable;

public abstract class Complication<Y extends Factory<Y,F,O,I,X,B,P>,D extends Datum<D,F,I,X,P,E>,F extends Fact<F,I,X,P,?,?,?>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<F,B>,P extends Progenitor<Y,F,O,I,X,B,P>,E extends Envoy<Y,D,F,O,I,X,B,P,E>,T extends Criterion<Y,D,F,O,I,X,B,P,E,T,PRE>,PRE extends Predictor<Y,D,F,O,I,X,B,P,E,T,PRE>,COMP extends Complication<Y,D,F,O,I,X,B,P,E,T,PRE,COMP>> implements Comparable<COMP>, Serializable {

    protected final PRE predictor;
    protected final T criterion;
    protected E envoy;


    public Complication(PRE predictor, T criterion) {
        this.predictor = predictor;
        this.criterion = criterion;
    }

    public static class Methodical<Y extends Factory<Y,F,O,I,X,B,P>,D extends Datum<D,F,I,X,P,E>,F extends Fact<F,I,X,P,?,?,?>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<F,B>,P extends Progenitor<Y,F,O,I,X,B,P>,E extends Envoy<Y,D,F,O,I,X,B,P,E>> extends Complication<Y,D,F,O,I,X,B,P,E,Criterion.Wrapped<Y,D,F,O,I,X,B,P,E>,Predictor.Handled<Y,D,F,O,I,X,B,P,E>,Methodical<Y,D,F,O,I,X,B,P,E>> {

        public Methodical(Predictor.Handled<Y,D,F,O,I,X,B,P,E> predictor, Criterion.Wrapped<Y,D,F,O,I,X,B,P,E> criterion) {
            super(predictor, criterion);
        }

        @Override
        public int compareTo(Methodical<Y,D,F,O,I,X,B,P,E> that) {
            return 0;
        }
    }
    public static class Replaced<Y extends Factory<Y,F,O,I,X,B,P>,D extends Datum<D,F,I,X,P,E>,F extends Fact<F,I,X,P,?,?,?>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<F,B>,P extends Progenitor<Y,F,O,I,X,B,P>,E extends Envoy<Y,D,F,O,I,X,B,P,E>,V extends DatumVisitor<Y,D,F,O,I,X,B,P,E>> extends Complication<Y,D,F,O,I,X,B,P,E,Criterion.Replacement<Y,D,F,O,I,X,B,P,E,V>,Predictor.Visited<Y,D,F,O,I,X,B,P,E,V>,Replaced<Y,D,F,O,I,X,B,P,E,V>> {
        public Replaced(Predictor.Visited<Y,D,F,O,I,X,B,P,E,V> predictor, Criterion.Replacement<Y,D,F,O,I,X,B,P,E,V> criterion) {
            super(predictor, criterion);
        }

        @Override
        public int compareTo(Replaced that) {
            return 0;
        }
    }
    public static class OnTime<Y extends Factory<Y,F,O,I,X,B,P>,D extends Datum<D,F,I,X,P,E>,F extends Fact<F,I,X,P,?,?,?>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<F,B>,P extends Progenitor<Y,F,O,I,X,B,P>,E extends Envoy<Y,D,F,O,I,X,B,P,E>> extends Complication<Y,D,F,O,I,X,B,P,E,Criterion.Chronological<Y,D,F,O,I,X,B,P,E>,Predictor.Time<Y,D,F,O,I,X,B,P,E>,OnTime<Y,D,F,O,I,X,B,P,E>> {

        public OnTime(Predictor.Time<Y,D,F,O,I,X,B,P,E> predictor, Criterion.Chronological<Y,D,F,O,I,X,B,P,E> criterion) {
            super(predictor, criterion);
        }

        @Override
        public int compareTo(OnTime<Y,D,F,O,I,X,B,P,E> o) {
            return 0;
        }
    }
    public static class Counter<Y extends Factory<Y,F,O,I,X,B,P>,D extends Datum<D,F,I,X,P,E>,F extends Fact<F,I,X,P,?,?,?>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<F,B>,P extends Progenitor<Y,F,O,I,X,B,P>,E extends Envoy<Y,D,F,O,I,X,B,P,E>> extends Complication<Y,D,F,O,I,X,B,P,E,Criterion.OnCountdown<Y,D,F,O,I,X,B,P,E>,Predictor.Downer<Y,D,F,O,I,X,B,P,E>,Counter<Y,D,F,O,I,X,B,P,E>> {

        public Counter(Predictor.Downer<Y,D,F,O,I,X,B,P,E> predictor, Criterion.OnCountdown<Y,D,F,O,I,X,B,P,E> criterion) {
            super(predictor, criterion);
        }

        @Override
        public int compareTo(Counter<Y,D,F,O,I,X,B,P,E> o) {
            return 0;
        }
    }

    public final PRE getPredictor() {
        return this.predictor;
    }
    public final T getCriterion() {
        return this.criterion;
    }
    public final E getEnvoy() {
        return this.envoy;
    }
    public final void setEnvoy(E envoy) {
        this.envoy = envoy;
    }

}
//        suppressors("Suppressor",""),
//        confounders("confounders",""),
//        covariates("convariates"),
//        mediators("mediator",""),
//        moderators("",""),
