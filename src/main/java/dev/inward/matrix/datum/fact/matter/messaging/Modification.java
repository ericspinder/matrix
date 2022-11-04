package dev.inward.matrix.datum.fact.matter.messaging;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.phenomenon.producer.promise.Promise;
import dev.inward.matrix.datum.fact.matter.Matter;
import dev.inward.matrix.datum.fact.matter.Indicia;

import java.time.Instant;
import java.util.UUID;

public class Modification<MOD extends Modification<MOD,P,RESP,REQ,IM,XM>,P extends Promise<P,RESP,REQ,IM,XM>,RESP extends Response<RESP,IM,XM>,REQ extends Request<REQ,IM,XM>,IM extends Identity<IM,XM>,XM extends Context<XM>> extends Matter<MOD,IM,XM> {

    protected final P promise;

    public Modification(UUID uuid, IM topicId, Instant createInstant, Indicia indicia, P promise) {
        super(uuid, topicId, createInstant, indicia);
        this.promise = promise;
    }

    public final P getPromise() {
        return this.promise;
    }
}
