package dev.inward.matrix.phenomenon.producer;

import dev.inward.matrix.Context;
import dev.inward.matrix.Identity;
import dev.inward.matrix.concept.matter.Exceptionally;
import dev.inward.matrix.concept.matter.Indicia;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class ExecutionExceptionly<VERSION extends Comparable<VERSION>,X extends Context<VERSION,X>> extends ExecutionException implements Exceptionally {

    protected final UUID id;
    protected final X context;
    protected final Indicia indicia;

    public ExecutionExceptionly(UUID id, X context, String locus, Exception e) {
        super(e);
        this.id = id;
        this.context = context;
        this.indicia = new Indicia(locus, Indicia.Focus.Admonitory, Indicia.Severity.Exceptional);
    }
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

    @Override
    public UUID getId() {
        return this.id;
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
