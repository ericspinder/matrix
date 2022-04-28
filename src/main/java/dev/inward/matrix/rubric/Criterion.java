package dev.inward.matrix.rubric;

import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Progenitor;
import dev.inward.matrix.datum.fact.notion.concept.Context;

import java.io.Serializable;


public abstract class Criterion<D extends Datum<D,F,I,X,P,E>,F extends Fact<F,I,X,P>,I extends Identity<I,X>,X extends Context<X>,P extends Progenitor<?,F,?,I,X,?,P,?,?>,E extends Envoy<?,D,F,?,I,X,?,P,?,?,E>,C extends Criterion<D,F,I,X,P,E,C>> implements Comparable<C>, Serializable {

    public static class Limiter<D extends Datum<D,F,I,X,P,E>,F extends Fact<F,I,X,P>,I extends Identity<I,X>,X extends Context<X>,P extends Progenitor<?,F,?,I,X,?,P,?,?>,E extends Envoy<?,D,F,?,I,X,?,P,?,?,E>> extends Criterion<D,F,I,X,E,P,Limiter<D,F,I,X,P,E>> {

        @Override
        public int compareTo(Limiter<D, F, I, X,P, E> that) {
            return 0;
        }
    }
    public static class Wrapped<D extends Datum<D,F,I,X,P,E>,F extends Fact<F,I,X,P>,I extends Identity<I,X>,X extends Context<X>,P extends Progenitor<?,F,?,I,X,?,P,?,?>,E extends Envoy<?,D,F,?,I,X,?,P,?,?,E>> extends Criterion<D,F,I,X,P,E,Wrapped<D,F,I,X,P,E>> {
        @Override
        public int compareTo(Wrapped<D,F,I,X,P,E> that) {
            return 0;
        }
    }
    public static class Replacement<D extends Datum<D,F,I,X,P,E>,F extends Fact<F,I,X,P>,I extends Identity<I,X>,X extends Context<X>,P extends Progenitor<?,F,?,I,X,?,P,?,?>,E extends Envoy<?,D,F,?,I,X,?,P,?,?,E>> extends Criterion<D,F,I,X,P,E,Replacement<D,F,I,X,P,E,V>> {

        @Override
        public int compareTo(Replacement<D,F,I,X,P,E> that) {
            return 0;
        }
    }
    public static class Chronological<D extends Datum<D,F,I,X,P,E>,F extends Fact<F,I,X,P>,I extends Identity<I,X>,X extends Context<X>,P extends Progenitor<?,F,?,I,X,?,P,?,?>,E extends Envoy<?,D,F,?,I,X,?,P,?,?,E>> extends Criterion<D,F,I,X,P,E, Chronological<D,F,I,X,P,E>> {

        @Override
        public int compareTo(Chronological<D,F,I,X,P,E> that) {
            return 0;
        }
    }
    public static class OnCountdown<D extends Datum<D,F,I,X,P,E>,F extends Fact<F,I,X,P>,I extends Identity<I,X>,X extends Context<X>,P extends Progenitor<?,F,?,I,X,?,P,?,?>,E extends Envoy<?,D,F,?,I,X,?,P,?,?,E>> extends Criterion<D,F,I,X,P,E,OnCountdown<D,F,I,X,P,E>> {
        @Override
        public int compareTo(OnCountdown<D,F,I,X,P,E> that) {
            return 0;
        }
    }

}
