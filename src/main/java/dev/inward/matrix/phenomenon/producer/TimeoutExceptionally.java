/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.phenomenon.producer;

import dev.inward.matrix.file.addressed.depot.indica.IndiciaKey;
import dev.inward.matrix.file.addressed.log.Matter;

import java.util.UUID;
import java.util.concurrent.TimeoutException;

public class TimeoutExceptionally extends TimeoutException implements Exceptionally {

    protected final UUID uuid;
    protected final Identity topicId;
    protected final IndiciaKey indiciaKey;
    protected final Object context;

    public TimeoutExceptionally(UUID uuid, Object context, Identity topicId, String locus) {
        this.uuid = uuid;
        this.topicId = topicId;
        if (context == null) {
            this.indiciaKey = new IndiciaKey(locus, IndiciaKey.Focus.Monitory, Matter.Severity.Nominal);
        }
        this.indiciaKey = new IndiciaKey(locus, IndiciaKey.Focus.Admonitory, Matter.Severity.Exceptional);
    }
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

    @Override
    public UUID getUuid() {
        return this.uuid;
    }

    @Override
    public Identity getTopicId() {
        return this.topicId;
    }

    @Override
    public IndiciaKey getIndicia() {
        return this.indiciaKey;
    }
}
