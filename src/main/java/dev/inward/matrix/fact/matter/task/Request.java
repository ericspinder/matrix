package dev.inward.matrix.fact.matter.task;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.matter.messaging.Engagement;
import dev.inward.matrix.fact.matter.messaging.Fingerprint;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.matter.Matter;
import dev.inward.matrix.fact.matter.Indicia;

import java.time.Instant;
import java.util.UUID;

public abstract class Request<Q extends Request<Q,I,X,S>,I extends Identity<I,X>,X extends Context<X>,E extends Engagement<E,F>,F extends Fingerprint> extends Matter<Q,I,X> {

    protected final ;
    public Request(UUID uuid, I topicId, Instant createInstant, Indicia indicia, S sanction) {
        super(uuid, topicId, createInstant, indicia);
        this.sanction = sanction;
    }
}
