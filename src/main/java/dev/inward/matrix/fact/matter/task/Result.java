package dev.inward.matrix.fact.matter.task;

import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.matter.Indicia;
import dev.inward.matrix.fact.matter.Matter;
import dev.inward.matrix.fact.Context;

import java.time.Instant;
import java.util.UUID;

public abstract class Result<R extends Result<R,I,X,Q>,I extends Identity<I,X>,X extends Context<X>,Q extends Request<Q,I,X,?>> extends Matter<R,I,X> {

    protected ReferencedMatter<Q> referencedMatter;
    public Result(UUID uuid, I subjectId, Instant createInstant, Indicia indicia, Q request) {
        super(uuid, subjectId, createInstant, indicia);

    }
}
