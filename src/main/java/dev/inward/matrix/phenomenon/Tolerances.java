package dev.inward.matrix.phenomenon;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public abstract class Tolerances {

    protected final Timeout waitingTimeout;
    protected final Timeout processingTimeout;
    protected final Timeout pickupTimeout;

    public Tolerances(Timeout waitingTimeout, Timeout processingTimeout, Timeout pickupTimeout) {
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
