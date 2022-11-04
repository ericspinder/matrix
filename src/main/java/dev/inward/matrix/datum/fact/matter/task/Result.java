package dev.inward.matrix.datum.fact.matter.task;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.matter.Matter;
import dev.inward.matrix.datum.fact.matter.Indicia;

import java.time.Instant;
import java.util.UUID;

public abstract class Result<R extends Result<R,I,X,Q>,I extends Identity<I,X>,X extends Context<X>,Q extends Request<Q,I,X,?>> extends Matter<R,I,X> {

    protected ReferencedMatter<Q> referencedMatter;
    public Result(UUID uuid, I subjectId, Instant createInstant, Indicia indicia, Q request) {
        super(uuid, subjectId, createInstant, indicia);

    }
}
