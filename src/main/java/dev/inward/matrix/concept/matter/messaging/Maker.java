package dev.inward.matrix.concept.matter.messaging;

import dev.inward.matrix.Identity;
import dev.inward.matrix.fact.intialized.Intialized;
import dev.inward.matrix.Context;
import dev.inward.matrix.phenomenon.producer.promise.Promise;

public abstract class Maker<M extends Maker<M,MOD,E,A,P,RESP,REQ, CI, CX>,MOD extends Modification<MOD,P,RESP,REQ, CI, CX>,E extends Escalation<E,P,RESP,REQ, CI, CX>,A extends Advice<A, CI, CX>,P extends Promise<P,RESP,REQ, CI, CX>,RESP extends Response<?,RESP, CI, CX>,REQ extends Request<REQ, CI, CX>, CI extends Identity<CI, CX>, CX extends Context<CX>> extends Intialized<M,Identity.Ego, Context.Demarc> {

    public Maker(Identity.Ego id) {
        super(id);
    }

    public abstract P request(REQ request);
    public abstract A validate(P promise);
    public abstract E modification(MOD modification );


}
