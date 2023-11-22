package dev.inward.matrix.phenomenon.producer;

import dev.inward.matrix.Identity;
import dev.inward.matrix.fact.matter.Exceptionally;
import dev.inward.matrix.fact.matter.Indicia;

import java.util.UUID;
import java.util.concurrent.TimeoutException;

public class TimeoutExceptionally extends TimeoutException implements Exceptionally {

    protected final UUID uuid;
    protected final Identity topicId;
    protected final Indicia indicia;
    protected final Object context;

    public TimeoutExceptionally(UUID uuid, Object context, Identity topicId, String locus) {
        this.uuid = uuid;
        this.topicId = topicId;
        if (context == null) {
            this.indicia = new Indicia(locus, Indicia.Focus.Monitory, Indicia.Severity.Nominal);
        }
        this.indicia = new Indicia(locus, Indicia.Focus.Admonitory, Indicia.Severity.Exceptional);
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
    public Indicia getIndicia() {
        return this.indicia;
    }
}
