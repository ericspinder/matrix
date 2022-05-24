package dev.inward.matrix.rubric;

import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Diplomat;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.Ambassador;
import dev.inward.matrix.datum.fact.notion.concept.Context;

import java.io.Serializable;


public abstract class Criterion<DATUM,D extends Datum<DATUM,D,E>,E extends Envoy<DATUM,D,E,F,I,X,P,N,NP>,F extends Fact<F,I,X,P>,I extends Identity<I,X>,X extends Context<X>,P extends Diplomat<?,F,?,I,X,?,P,N,NP>,N extends Notion<N,I,X,NP>,NP extends Ambassador<?, N,?,I,X,?,NP,?,?>,CRIT extends Criterion<DATUM,D,E,F,I,X,P,N,NP,CRIT>> implements Comparable<CRIT>, Serializable {

    public static class Limiter<DATUM,D extends Datum<DATUM,D,E>,E extends Envoy<DATUM,D,E,F,I,X,P,N,NP>,F extends Fact<F,I,X,P>,I extends Identity<I,X>,X extends Context<X>,P extends Diplomat<?,F,?,I,X,?,P,N,NP>,N extends Notion<N,I,X,NP>,NP extends Ambassador<?,N,?,I,X,?,NP,?,?>> extends Criterion<DATUM,D,E,F,I,X,P,N,NP,Limiter<DATUM,D,E,F,I,X,P,N,NP>> {
        @Override
        public int compareTo(Limiter<DATUM,D,E,F,I,X,P, N, NP> that) {
            return 0;
        }
    }
    public static class Wrapped<DATUM,D extends Datum<DATUM,D,E>,E extends Envoy<DATUM,D,E,F,I,X,P,N,NP>,F extends Fact<F,I,X,P>,I extends Identity<I,X>,X extends Context<X>,P extends Diplomat<?,F,?,I,X,?,P, N,NP>,N extends Notion<N,I,X,NP>,NP extends Ambassador<?, N,?,I,X,?, NP,?,?>> extends Criterion<DATUM,D,E,F,I,X,P,N,NP,Wrapped<DATUM,D,E,F,I,X,P,N,NP>> {
        @Override
        public int compareTo(Wrapped<DATUM,D,E,F,I,X,P,N,NP> that) {
            return 0;
        }
    }
    public static class Replacement<DATUM,D extends Datum<DATUM,D,E>,E extends Envoy<DATUM,D,E,F,I,X,P,N,NP>,F extends Fact<F,I,X,P>,I extends Identity<I,X>,X extends Context<X>,P extends Diplomat<?,F,?,I,X,?,P,N,NP>,N extends Notion<N,I,X,NP>,NP extends Ambassador<?,N,?,I,X,?,NP,?,?>> extends Criterion<DATUM,D,E,F,I,X,P,N,NP,Replacement<DATUM,D,E,F,I,X,P,N,NP>> {
        @Override
        public int compareTo(Replacement<DATUM,D,E,F,I,X,P,N,NP> that) {
            return 0;
        }
    }
    public static class Chronological<DATUM,D extends Datum<DATUM,D,E>,E extends Envoy<DATUM,D,E,F,I,X,P, N, NP>,F extends Fact<F,I,X,P>,I extends Identity<I,X>,X extends Context<X>,P extends Diplomat<?,F,?,I,X,?,P,N,NP>,N extends Notion<N,I,X,NP>,NP extends Ambassador<?,N,?,I,X,?,NP,?,?>> extends Criterion<DATUM,D,E,F,I,X,P,N,NP,Chronological<DATUM,D,E,F,I,X,P,N,NP>> {
        @Override
        public int compareTo(Chronological<DATUM,D,E,F,I,X,P, N, NP> that) {
            return 0;
        }
    }
    public static class OnCountdown<DATUM,D extends Datum<DATUM,D,E>,E extends Envoy<DATUM,D,E,F,I,X,P,N,NP>,F extends Fact<F,I,X,P>,I extends Identity<I,X>,X extends Context<X>,P extends Diplomat<?,F,?,I,X,?,P,N,NP>,N extends Notion<N,I,X,NP>,NP extends Ambassador<?,N,?,I,X,?,NP,?,?>> extends Criterion<DATUM,D,E,F,I,X,P,N,NP,OnCountdown<DATUM,D,E,F,I,X,P,N,NP>> {
        @Override
        public int compareTo(OnCountdown<DATUM,D,E,F,I,X,P,N,NP> that) {
            return 0;
        }
    }
}
