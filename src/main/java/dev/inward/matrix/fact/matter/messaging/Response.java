package dev.inward.matrix.fact.matter.messaging;

import dev.inward.matrix.Identity;
import dev.inward.matrix.fact.matter.Indicia;
import dev.inward.matrix.fact.matter.Matter;
import dev.inward.matrix.Context;

import java.time.Instant;
import java.util.UUID;

public abstract class Response<PAYLOAD,RESP extends Response<PAYLOAD,RESP,CI, CX>,CI extends Identity<CI,CX>,CX extends Context<CX>> extends Matter<RESP,CI,CX> {

    protected PAYLOAD payload;
    public Response(UUID uuid, CI topicId, Instant createInstant, Indicia indicia, PAYLOAD payload) {
        super(uuid, topicId, createInstant, indicia);
        this.payload = payload;
    }
}
