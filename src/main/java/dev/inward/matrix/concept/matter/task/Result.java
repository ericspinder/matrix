package dev.inward.matrix.concept.matter.task;

import dev.inward.matrix.Identity;
import dev.inward.matrix.concept.matter.Indicia;
import dev.inward.matrix.concept.matter.Matter;
import dev.inward.matrix.Context;

import java.time.Instant;
import java.util.UUID;

public abstract class Result<R extends Result<R,I,X,Q>,I extends Identity<I,X>,X extends Context<X>,Q extends Request<Q,I,X,?>> extends Matter<R,I,X> {

    protected ReferencedMatter<Q> referencedMatter;
    public Result(UUID uuid, I subjectId, Instant createInstant, Indicia indicia, Q request) {
        super(uuid, subjectId, createInstant, indicia);

    }
}
