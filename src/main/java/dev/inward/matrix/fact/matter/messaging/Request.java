package dev.inward.matrix.fact.matter.messaging;

import dev.inward.matrix.Identity;
import dev.inward.matrix.fact.matter.Indicia;
import dev.inward.matrix.fact.matter.Matter;
import dev.inward.matrix.Context;

import java.time.Instant;
import java.util.UUID;

public class Request<PAYLOAD,REQ extends Request<PAYLOAD,REQ,I,X>,I extends Identity<I,X>,X extends Context<X>,E extends Engagement<E,I,X,?>> extends Matter<REQ,I,X> {

    protected PAYLOAD payload;
    protected Engagement engagement;
    public Request(UUID uuid, IMAT topicId, Instant createInstant, Indicia indicia, PAYLOAD payload) {
        super(uuid, topicId, createInstant, indicia);
        this.payload = payload;
    }
}
