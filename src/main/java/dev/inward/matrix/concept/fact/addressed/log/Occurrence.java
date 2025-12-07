/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.fact.addressed.log;

import java.time.Duration;
import java.time.Instant;
import java.util.UUID;

public class Occurrence implements Comparable<Occurrence> {

    protected final UUID uuid;
    protected final Instant createTime;

    protected final Log.Severity severity;
    protected Duration duration;

    public Occurrence(UUID uuid, Instant createTime, Log.Severity severity) {
        this.uuid = uuid;
        this.createTime = createTime;
        this.severity = severity;
    }
    public final UUID getUUID() {
        return this.uuid;
    }

    @Override
    public int compareTo(Occurrence that) {
        int isZero = this.createTime.compareTo(that.createTime);
        if (isZero == 0) {
            return this.uuid.compareTo(that.uuid);
        }
        return isZero;
    }
    public void markEnd() {
        this.duration = Duration.between(createTime,Instant.now());
    }
}
