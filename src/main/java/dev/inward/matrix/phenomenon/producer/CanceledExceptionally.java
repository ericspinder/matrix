package dev.inward.matrix.phenomenon.producer;

import dev.inward.matrix.Identity;
import dev.inward.matrix.fact.matter.Exceptionally;
import dev.inward.matrix.fact.matter.Indicia;

import java.util.UUID;
import java.util.concurrent.CancellationException;

public class CanceledExceptionally extends CancellationException implements Exceptionally {

    protected final Identity.Ghost ghost;
    protected final Identity topicId;
    protected final Indicia indicia;

    public CanceledExceptionally(UUID uuid, Object context, Identity topicId, String locus) {
        this.ghost = new Identity.Ghost(topicId.getContext().get);
        this
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
