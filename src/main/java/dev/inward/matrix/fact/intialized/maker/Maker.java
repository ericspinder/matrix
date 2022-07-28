package dev.inward.matrix.fact.intialized.maker;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.intialized.Intialized;
import dev.inward.matrix.matter.Escalation;
import dev.inward.matrix.matter.Promise;
import dev.inward.matrix.matter.Request;
import dev.inward.matrix.matter.Response;

public abstract class Maker<M extends Maker<M,E,P,A,RESP,REQ,IMAT,XMAT>,E extends Escalation<E,P,RESP,REQ,IMAT,XMAT>,A extends Advice<IMAT,XMAT>,P extends Promise<RESP,REQ,IMAT,XMAT>,RESP extends Response<RESP,IMAT,XMAT>,REQ extends Request<REQ,IMAT,XMAT>,IMAT extends Identity<IMAT,XMAT>,XMAT extends Context<XMAT>> extends Intialized<M,Identity.Ego,Context.JVM> {

    public Maker(Identity.Ego id) {
        super(id);
    }

    public abstract P request(REQ request);
    public abstract P validate(P promise);
    public abstract E cancel(P promise);


}
