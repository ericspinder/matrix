package crud.rubric.aggregation;

import dev.inward.matrix.NotionStartupException;

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

    public void finish() {
        if (this.duration == null) {
            this.duration = Duration.between(this.start, Instant.now());
        }
        throw new NotionStartupException(NotionStartupException.Type.Cannot_Update_Timer, this.getClass());
    }
    public Instant getStart() {
        return this.start;
    }
    public Duration getDuration() {
        return this.duration;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(", startTime=").append(this.start).append(", duration=").append(this.duration);
        return stringBuilder.toString();
    }
}
