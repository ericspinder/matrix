package dev.inward.matrix.fact;

import dev.inward.matrix.engine.DatumVisitor;
import dev.inward.matrix.fact.datum.Envoy;
import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.matter.Exceptional;

import java.util.concurrent.ExecutionException;

public abstract class Criterion<DATUM> {

    protected final String name;
    //public abstract void process(Envoy<DATUM,?,?> envoy) throws ExecutionException;

    public Criterion(String name) {
        this.name = name;
    }

    public static class Limiter<DATUM> extends Criterion<DATUM> {

        protected final int totalAllowed;
        protected final int warnLevel;

        public Limiter(String name, int totalAllowed, int warnLevel, Identity.Ego authority) {
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

        protected final DatumVisitor<DATUM> datumVisitor;
        public Wrapped(String name, DatumVisitor<DATUM> datumVisitor) {
            super(name);
            this.datumVisitor = datumVisitor;
        }
        public DatumVisitor<DATUM> getDatumVisitor() {
            return this.datumVisitor;
        }
    }
    public static class Restrictor<DATUM> extends Criterion<DATUM> {

        protected final DATUM maxValue;
        protected final DATUM minValue;
        public Restrictor(String name, DATUM maxValue, DATUM minValue) {
            super(name);
            this.maxValue = maxValue;
            this.minValue = minValue;
        }

        public DATUM getMaxValue() {
            return maxValue;
        }

        public DATUM getMinValue() {
            return minValue;
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

    public String getName() {
        return name;
    }
}