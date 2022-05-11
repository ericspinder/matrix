package dev.inward.matrix.rubric;

import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Progenitor;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.Primogenitor;
import dev.inward.matrix.datum.fact.notion.concept.Concept;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Mortal;

import java.io.Serializable;


public abstract class Criterion<DATUM,D extends Datum<DATUM,D,F,I,X,P,NP,PP,E>,F extends Fact<F,I,X,P>,I extends Identity<I,X>,X extends Context<X>,P extends Progenitor<?,F,?,I,X,?,P,NP,PP,C,M>,NP extends Notion<NP,I,X,PP>,PP extends Primogenitor<?,NP,?,I,X,?,PP,C,M>,C extends Concept<C,?,M>,M extends Mortal<?,C,?,?,?,M>,E extends Envoy<?,DATUM,D,F,?,I,X,?,P,NP,PP,C,M,E>,R extends Criterion<DATUM,D,F,I,X,P,NP,PP,C,M,E,R>> implements Comparable<R>, Serializable {

    public static class Limiter<DATUM,D extends Datum<DATUM,D,F,I,X,P,NP,PP,E>,F extends Fact<F,I,X,P>,I extends Identity<I,X>,X extends Context<X>,P extends Progenitor<?,F,?,I,X,?,P,NP,PP,C,M>,NP extends Notion<NP,I,X,PP>,PP extends Primogenitor<?,NP,?,I,X,?,PP,C,M>,C extends Concept<C,?,M>,M extends Mortal<?,C,?,?,?,M>,E extends Envoy<?,DATUM,D,F,?,I,X,?,P,NP,PP,C,M,E>> extends Criterion<DATUM,D,F,I,X,P,NP,PP,E,Limiter<DATUM,D,F,I,X,P,NP,PP,C,M,E>> {

        @Override
        public int compareTo(Limiter<DATUM,D,F,I,X,P,NP,PP,C,M,E> that) {
            return 0;
        }
    }
    public static class Wrapped<DATUM,D extends Datum<DATUM,D,F,I,X,P,NP,PP,E>,F extends Fact<F,I,X,P>,I extends Identity<I,X>,X extends Context<X>,P extends Progenitor<?,F,?,I,X,?,P,NP,PP>,NP extends Notion<NP,I,X,PP>,PP extends Primogenitor<?,NP,?,I,X,?,PP>,E extends Envoy<?,DATUM,D,F,?,I,X,?,P,NP,PP,E>> extends Criterion<DATUM,D,F,I,X,P,NP,PP,E,Wrapped<DATUM,D,F,I,X,P,NP,PP,E>> {
        @Override
        public int compareTo(Wrapped<DATUM,D,F,I,X,P,NP,PP,E> that) {
            return 0;
        }
    }
    public static class Replacement<DATUM,D extends Datum<DATUM,D,F,I,X,P,NP,PP,E>,F extends Fact<F,I,X,P>,I extends Identity<I,X>,X extends Context<X>,P extends Progenitor<?,F,?,I,X,?,P,NP,PP>,NP extends Notion<NP,I,X,PP>,PP extends Primogenitor<?,NP,?,I,X,?,PP>,E extends Envoy<?,DATUM,D,F,?,I,X,?,P,NP,PP,E>> extends Criterion<DATUM,D,F,I,X,P,NP,PP,E,Replacement<DATUM,D,F,I,X,P,NP,PP,E>> {

        @Override
        public int compareTo(Replacement<DATUM,D,F,I,X,P,NP,PP,E> that) {
            return 0;
        }
    }
    public static class Chronological<DATUM,D extends Datum<DATUM,D,F,I,X,P,NP,PP,E>,F extends Fact<F,I,X,P>,I extends Identity<I,X>,X extends Context<X>,P extends Progenitor<?,F,?,I,X,?,P,NP,PP>,NP extends Notion<NP,I,X,PP>,PP extends Primogenitor<?,NP,?,I,X,?,PP>,E extends Envoy<?,DATUM,D,F,?,I,X,?,P,NP,PP,E>> extends Criterion<DATUM,D,F,I,X,P,NP,PP,E, Chronological<DATUM,D,F,I,X,P,NP,PP,E>> {

        @Override
        public int compareTo(Chronological<DATUM,D,F,I,X,P,NP,PP,E> that) {
            return 0;
        }
    }
    public static class OnCountdown<DATUM,D extends Datum<DATUM,D,F,I,X,P,NP,PP,E>,F extends Fact<F,I,X,P>,I extends Identity<I,X>,X extends Context<X>,P extends Progenitor<?,F,?,I,X,?,P,NP,PP>,NP extends Notion<NP,I,X,PP>,PP extends Primogenitor<?,NP,?,I,X,?,PP>,E extends Envoy<?,DATUM,D,F,?,I,X,?,P,NP,PP,E>> extends Criterion<DATUM,D,F,I,X,P,NP,PP,E,OnCountdown<DATUM,D,F,I,X,P,NP,PP,E>> {
        @Override
        public int compareTo(OnCountdown<DATUM,D,F,I,X,P,NP,PP,E> that) {
            return 0;
        }
    }
}
