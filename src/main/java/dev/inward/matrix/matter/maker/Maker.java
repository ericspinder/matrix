package dev.inward.matrix.matter.maker;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.intialized.Intialized;
import dev.inward.matrix.matter.worker.promise.Promise;

public abstract class Maker<M extends Maker<M,MOD,E,A,P,RESP,REQ, CI, CX>,MOD extends Modification<MOD,P,RESP,REQ, CI, CX>,E extends Escalation<E,P,RESP,REQ, CI, CX>,A extends Advice<A, CI, CX>,P extends Promise<P,RESP,REQ, CI, CX>,RESP extends Response<RESP, CI, CX>,REQ extends Request<REQ, CI, CX>, CI extends Identity<CI, CX>, CX extends Context<CX>> extends Intialized<M,Identity.Ego, Context.Ethereal> {

    public Maker(Identity.Ego id) {
        super(id);
    }

    public abstract P request(REQ request);
    public abstract A validate(P promise);
    public abstract E modification(MOD modification );


}
