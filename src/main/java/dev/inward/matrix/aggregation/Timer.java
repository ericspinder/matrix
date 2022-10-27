package dev.inward.matrix.aggregation;


import java.time.Duration;
import java.time.Instant;

public class Timer {
    private final Instant start;
    private Duration duration = null;

    public Timer() {
        this.start = Instant.now();
    }
    public Timer(Instant start, Duration duration) {
        this.start = start;
        this.duration = duration;
    }

    /**
     * The Finish method is called to complete the timer and will return null
     * rather than the previously stored duration if this method is called a second time.
     * Use getDuration() to read that value second time.
     * @return the duration from start or null if the finish had already been called.
     */
    public Duration finish() {
        if (this.duration == null) {
            this.duration = Duration.between(this.start, Instant.now());
            return this.duration;
        }
        else {
            return null;
        }
    }
    public Instant getStartInstant() {
        return this.start;
    }
    public Duration getDuration() {
        return this.duration;
    }
    public Instant getEndInstant() {
        return this.start.plus(this.duration);
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(", startTime=").append(this.start).append(", duration=").append(this.duration);
        return stringBuilder.toString();
    }
}
