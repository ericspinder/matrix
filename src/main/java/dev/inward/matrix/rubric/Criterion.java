package dev.inward.matrix.rubric;

import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Diplomat;
import dev.inward.matrix.datum.fact.notion.concept.Context;

public abstract class Criterion<DATUM,D extends Datum<DATUM,D,E,F,I,X,P>,E extends Envoy<DATUM,D,E,F,I,X,P>,F extends Fact<F,I,X,P>,I extends Identity<I,X>,X extends Context<X>,P extends Diplomat<?,F,?,I,X,?,P,?,?>,CRIT extends Criterion<DATUM,D,E,F,I,X,P,CRIT>> implements Identity.Addressable<CRIT,I,X> {

    protected final String name;
    protected final X context;

    public Criterion(String name, X context) {
        this.name = name;
        this.context = context;
    }

    public static class Limiter<DATUM,D extends Datum<DATUM,D,E,F,I,X,P>,E extends Envoy<DATUM,D,E,F,I,X,P>,F extends Fact<F,I,X,P>,I extends Identity<I,X>,X extends Context<X>,P extends Diplomat<?,F,?,I,X,?,P,?,?>> extends Criterion<DATUM,D,E,F,I,X,P,Limiter<DATUM,D,E,F,I,X,P>> {
        public Limiter(String name, X context) {
            super(name, context);
        }

        @Override
        public int compareTo(Limiter<DATUM,D,E,F,I,X,P> that) {
            return 0;
        }
    }
    public static class Wrapped<DATUM,D extends Datum<DATUM,D,E,F,I,X,P>,E extends Envoy<DATUM,D,E,F,I,X,P>,F extends Fact<F,I,X,P>,I extends Identity<I,X>,X extends Context<X>,P extends Diplomat<?,F,?,I,X,?,P,?,?>> extends Criterion<DATUM,D,E,F,I,X,P,Wrapped<DATUM,D,E,F,I,X,P>> {
        @Override
        public int compareTo(Wrapped<DATUM,D,E,F,I,X,P> that) {
            return 0;
        }
    }
    public static class Replacement<DATUM,D extends Datum<DATUM,D,E,F,I,X,P>,E extends Envoy<DATUM,D,E,F,I,X,P>,F extends Fact<F,I,X,P>,I extends Identity<I,X>,X extends Context<X>,P extends Diplomat<?,F,?,I,X,?,P,?,?>> extends Criterion<DATUM,D,E,F,I,X,P,Replacement<DATUM,D,E,F,I,X,P>> {
        @Override
        public int compareTo(Replacement<DATUM,D,E,F,I,X,P> that) {
            return 0;
        }
    }
    public static class Chronological<DATUM,D extends Datum<DATUM,D,E,F,I,X,P>,E extends Envoy<DATUM,D,E,F,I,X,P>,F extends Fact<F,I,X,P>,I extends Identity<I,X>,X extends Context<X>,P extends Diplomat<?,F,?,I,X,?,P,?,?>> extends Criterion<DATUM,D,E,F,I,X,P,Chronological<DATUM,D,E,F,I,X,P>> {
        @Override
        public int compareTo(Chronological<DATUM,D,E,F,I,X,P> that) {
            return 0;
        }
    }
    public static class OnCountdown<DATUM,D extends Datum<DATUM,D,E,F,I,X,P>,E extends Envoy<DATUM,D,E,F,I,X,P>,F extends Fact<F,I,X,P>,I extends Identity<I,X>,X extends Context<X>,P extends Diplomat<?,F,?,I,X,?,P,?,?>> extends Criterion<DATUM,D,E,F,I,X,P,OnCountdown<DATUM,D,E,F,I,X,P>> {
        @Override
        public int compareTo(OnCountdown<DATUM,D,E,F,I,X,P> that) {
            return 0;
        }
    }
    public I getId() {
        return this.
    }
}
