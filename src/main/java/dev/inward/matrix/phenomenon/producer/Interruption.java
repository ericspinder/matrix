package dev.inward.matrix.phenomenon.producer;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.matter.Exceptional;
import dev.inward.matrix.fact.matter.Indicia;

import java.util.UUID;

public class Interruption extends InterruptedException implements Exceptional  {

    protected final UUID uuid;
    protected final Identity topicId;
    protected final Indicia indicia;

    public Interruption(UUID uuid, Identity topicId, String locus, char authorityCode) {
        this.uuid = uuid;
        this.topicId = topicId;
        this.indicia = new Indicia(locus, Indicia.Focus.Admonitory, Indicia.Severity.Exceptional, authorityCode);
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
