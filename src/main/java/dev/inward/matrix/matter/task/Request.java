package dev.inward.matrix.matter.task;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.matter.Matter;
import dev.inward.matrix.matter.Indicia;
import dev.inward.matrix.matter.sanction.Sanction;

import java.time.Instant;
import java.util.UUID;

public abstract class Request<Q extends Request<Q,I,X,S>,I extends Identity<I,X>,X extends Context<X>,S extends Sanction<S,I,X,?>> extends Matter<Q,I,X> {

    protected final S sanction;
    public Request(UUID uuid, I topicId, Instant createInstant, Indicia indicia, S sanction) {
        super(uuid, topicId, createInstant, indicia);
        this.sanction = sanction;
    }
}
