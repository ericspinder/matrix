package dev.inward.matrix.rubric;

import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Diplomat;
import dev.inward.matrix.datum.fact.notion.concept.Context;

public abstract class Criterion<DATUM,D extends Datum<DATUM,D, V,F,I,X,P>, V extends Envoy<DATUM,D, V,F,I,X,P>,F extends Fact<F,I,X,P>,I extends Identity<I,X>,X extends Context<X>,P extends Diplomat<?,F,?,I,X,?,P>> {

    protected final String name;

    public Criterion(String name) {
        this.name = name;
    }

    public static class Limiter<DATUM,D extends Datum<DATUM,D, V,F,I,X,P>, V extends Envoy<DATUM,D, V,F,I,X,P>,F extends Fact<F,I,X,P>,I extends Identity<I,X>,X extends Context<X>,P extends Diplomat<?,F,?,I,X,?,P>> extends Criterion<DATUM,D, V,F,I,X,P> {

        protected final int totalAllowed;
        protected final int warnLevel;

        public Limiter(String name, int totalAllowed, int warnLevel) {
            super(name);
            this.totalAllowed = totalAllowed;
            this.warnLevel = warnLevel;
        }
        public int getTotalAllowed() {
            return totalAllowed;
        }

        public int getWarnLevel() {
            return warnLevel;
        }
    }
    public static class Wrapped<DATUM,D extends Datum<DATUM,D, V,F,I,X,P>, V extends Envoy<DATUM,D, V,F,I,X,P>,F extends Fact<F,I,X,P>,I extends Identity<I,X>,X extends Context<X>,P extends Diplomat<?,F,?,I,X,?,P>> extends Criterion<DATUM,D, V,F,I,X,P> {
        public Wrapped(String name) {
            super(name);
        }
    }
    public static class Replacement<DATUM,D extends Datum<DATUM,D, V,F,I,X,P>, V extends Envoy<DATUM,D, V,F,I,X,P>,F extends Fact<F,I,X,P>,I extends Identity<I,X>,X extends Context<X>,P extends Diplomat<?,F,?,I,X,?,P>> extends Criterion<DATUM,D, V,F,I,X,P> {
        public Replacement(String name) {
            super(name);
        }
    }
    public static class Chronological<DATUM,D extends Datum<DATUM,D, V,F,I,X,P>, V extends Envoy<DATUM,D, V,F,I,X,P>,F extends Fact<F,I,X,P>,I extends Identity<I,X>,X extends Context<X>,P extends Diplomat<?,F,?,I,X,?,P>> extends Criterion<DATUM,D, V,F,I,X,P> {
        public Chronological(String name) {
            super(name);
        }
    }
    public static class OnCountdown<DATUM,D extends Datum<DATUM,D, V,F,I,X,P>, V extends Envoy<DATUM,D, V,F,I,X,P>,F extends Fact<F,I,X,P>,I extends Identity<I,X>,X extends Context<X>,P extends Diplomat<?,F,?,I,X,?,P>> extends Criterion<DATUM,D, V,F,I,X,P> {
        public OnCountdown(String name) {
            super(name);
        }
    }
}
