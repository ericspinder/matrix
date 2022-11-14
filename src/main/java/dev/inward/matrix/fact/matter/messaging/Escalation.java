package dev.inward.matrix.fact.matter.messaging;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.phenomenon.producer.promise.Promise;
import dev.inward.matrix.fact.matter.Matter;
import dev.inward.matrix.fact.matter.Indicia;

import java.time.Instant;
import java.util.UUID;

public class Escalation<E extends Escalation<E,P,RESP,REQ,CI,CX>,P extends Promise<P,RESP,REQ,CI,CX>,RESP extends Response<RESP,CI,CX>,REQ extends Request<REQ,CI,CX>,CI extends Identity<CI,CX>,CX extends Context<CX>> extends Matter<E,CI,CX> {

    public Escalation(UUID uuid, CI topicId, Instant createInstant, Indicia indicia) {
        super(uuid, topicId, createInstant, indicia);
    }
}
