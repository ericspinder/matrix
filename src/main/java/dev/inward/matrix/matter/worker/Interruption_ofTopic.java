package dev.inward.matrix.matter.worker;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.matter.Exceptional;
import dev.inward.matrix.matter.Indicia;

import java.util.UUID;

public class Interruption_ofTopic extends InterruptedException implements Exceptional  {

    protected final UUID uuid;
    protected final Identity topicId;
    protected final Indicia indicia;

    public Interruption_ofTopic(UUID uuid, Identity topicId, String locus) {
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
