package dev.inward.matrix.datum;

import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.matter.Matter;
import dev.inward.matrix.datum.fact.matter.Indicia;

import java.time.Instant;
import java.util.UUID;

public class Result<I extends Identity<I,X>,X extends Context<X>,D extends Datum<D,?,I,X,?,?>, R extends Result<I,X,D,R>> extends Matter<I,X,R> {

    public Result(UUID uuid, I topicId, Instant createInstant, Indicia indicia) {
        super(uuid, topicId, createInstant, indicia);
    }

}
