package dev.inward.matrix.fact.datum;

import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.matter.Indicia;
import dev.inward.matrix.fact.matter.Matter;
import dev.inward.matrix.fact.Context;

import java.time.Instant;
import java.util.UUID;

public class Result<I extends Identity<I,X>,X extends Context<X>,D extends dev.inward.matrix.fact.Fact<D, Identity.WebPage, Context.Path>, R extends Result<I,X,D,R>> extends Matter<I,X,R> {

    public Result(UUID uuid, I topicId, Instant createInstant, Indicia indicia) {
        super(uuid, topicId, createInstant, indicia);
    }

}
