package dev.inward.matrix.phenomenon;

import dev.inward.matrix.director.library.catalog.Metrics;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public abstract class Tolerant<T extends Tolerant<T,G>,G extends Identity.Individual<G>> extends Metrics<T,G> {

    protected final Timeout waitingTimeout;
    protected final Timeout processingTimeout;
    protected final Timeout pickupTimeout;

    public Tolerant(String label, String description, Timeout waitingTimeout, Timeout processingTimeout, Timeout pickupTimeout) {
        super(label, description);
        this.waitingTimeout = waitingTimeout;
        this.processingTimeout = processingTimeout;
        this.pickupTimeout = pickupTimeout;
    }

    public Timeout getWaitingTimeout() {
        return waitingTimeout;
    }

    public Timeout getPickupTimeout() {
        return pickupTimeout;
    }

    public Timeout getProcessingTimeout() {
        return processingTimeout;
    }

    public record Timeout(long timeout, TimeUnit timeUnit) {

        public long getTimeout() {
            return timeout;
        }

        public TimeUnit getTimeUnit() {
            return timeUnit;
        }

        public Duration duration() {
            return Duration.of(timeout, timeUnit.toChronoUnit());
        }
    }
}
