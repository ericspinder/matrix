package dev.inward.matrix.phenomenon.producer;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.matter.Exceptional;
import dev.inward.matrix.datum.fact.matter.Indicia;

import java.util.UUID;
import java.util.concurrent.TimeoutException;

public class Timout extends TimeoutException implements Exceptional {

    protected final UUID uuid;
    protected final Identity topicId;
    protected final Indicia indicia;

    public Timout(UUID uuid, Identity topicId, String locus) {
        this.uuid = uuid;
        this.topicId = topicId;
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
