package dev.inward.matrix.phenomenon;

import dev.inward.matrix.matter.Matter;

import java.util.concurrent.TimeUnit;

public abstract class Tolerances<M extends Matter<M,?,?>,T extends Tolerances<M,T>> {

    protected long timeout;
    protected TimeUnit timeUnit;

    public static class NetworkTolerances extends Tolerances<SystemInitialization, Tolerances.NetworkTolerances> {
        public NetworkTolerances() {

        }
    }
}
