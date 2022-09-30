package dev.inward.matrix.rubric;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.notion.concept.Context;

public abstract class Criterion<DATUM> {

    protected final String name;

    public Criterion(String name) {
        this.name = name;
    }

    public static class Limiter<DATUM,F extends Fact<F,I,X,?,?,?>,I extends Identity<I,X>,X extends Context<X>> extends Criterion<DATUM> {

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
    public static class Wrapped<DATUM> extends Criterion<DATUM> {
        public Wrapped(String name) {
            super(name);
        }
    }
    public static class Replacement<DATUM> extends Criterion<DATUM> {
        public Replacement(String name) {
            super(name);
        }
    }
    public static class Chronological<DATUM> extends Criterion<DATUM> {
        public Chronological(String name) {
            super(name);
        }
    }
    public static class OnCountdown<DATUM> extends Criterion<DATUM> {
        public OnCountdown(String name) {
            super(name);
        }
    }
}