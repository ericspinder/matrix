package dev.inward.matrix.phenomenon;

import dev.inward.matrix.fact.matter.Matter;

import java.util.concurrent.TimeUnit;

public abstract class Tolerances<M extends Matter<M,?,?>,T extends Tolerances<M,T>> {

    protected long timeout;
    protected TimeUnit timeUnit;

    public static class ThresholdTolerances extends Tolerances<SystemInitialization, ThresholdTolerances> {
        public ThresholdTolerances() {

        }
    }
}
