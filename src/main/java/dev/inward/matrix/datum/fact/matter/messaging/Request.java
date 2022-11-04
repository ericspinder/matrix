package dev.inward.matrix.datum.fact.matter.messaging;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.matter.Matter;
import dev.inward.matrix.datum.fact.matter.Indicia;

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
