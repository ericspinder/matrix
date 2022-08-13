package dev.inward.matrix.datum.fact.intialized.maker;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.intialized.Intialized;

public abstract class Maker<M extends Maker<M,MOD,E,A,P,RESP,REQ,IM,XM>,MOD extends Modification<MOD,P,RESP,REQ, IM, XM>,E extends Escalation<E,P,RESP,REQ, IM, XM>,A extends Advice<A,IM,XM>,P extends Promise<RESP,REQ, IM, XM>,RESP extends Response<RESP, IM, XM>,REQ extends Request<REQ, IM, XM>, IM extends Identity<IM, XM>, XM extends Context<XM>> extends Intialized<M,Identity.Ego,Context.JVM> {

    public Maker(Identity.Ego id) {
        super(id);
    }

    public abstract P request(REQ request);
    public abstract A validate(P promise);
    public abstract E modification(MOD modification );


}
