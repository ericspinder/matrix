package com.notionds.dataSupplier.aggregation;

import com.notionds.dataSupplier.NotionStartupException;

import java.time.Duration;
import java.time.Instant;

public class Timer {
    private final Instant startTime;
    private Duration duration = null;

    public Timer() {
        this.startTime = Instant.now();
    }
    public Timer(Instant startTime, Duration duration) {
        this.startTime = startTime;
        this.duration = duration;
    }

    public void setFinishTime(Instant finishTime) {
        if (this.duration == null) {
            this.duration = Duration.between(this.startTime, finishTime);
        }
        throw new NotionStartupException(NotionStartupException.Type.Cannot_Update_Timer, this.getClass());
    }
    public Instant getStartTime() {
        return this.startTime;
    }
    public Duration getDuration() {
        return this.duration;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(", startTime=").append(this.startTime).append(", duration=").append(this.duration);
        return stringBuilder.toString();
    }
}
