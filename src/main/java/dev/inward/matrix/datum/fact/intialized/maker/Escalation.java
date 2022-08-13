package dev.inward.matrix.datum.fact.intialized.maker;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.matter.Matter;
import dev.inward.matrix.matter.Indicia;

import java.time.Instant;
import java.util.UUID;

public class Escalation<E extends Escalation<E,P,RESP,REQ,IE,XE>,P extends Promise<RESP,REQ,IE,XE>,RESP extends Response<RESP,IE,XE>,REQ extends Request<REQ,IE,XE>,IE extends Identity<IE,XE>,XE extends Context<XE>> extends Matter<E,IE,XE> {

    public Escalation(UUID uuid, IE topicId, Instant createInstant, Indicia indicia) {
        super(uuid, topicId, createInstant, indicia);
    }
}
