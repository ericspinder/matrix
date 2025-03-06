/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;


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
        return ", startTime=" + this.start + ", duration=" + this.duration;
    }
}
