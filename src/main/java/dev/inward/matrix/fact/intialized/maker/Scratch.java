package dev.inward.matrix.fact.intialized.maker;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.intialized.Book;
import dev.inward.matrix.matter.Promise;
import dev.inward.matrix.matter.Request;
import dev.inward.matrix.matter.Response;

public class Scratch<M extends Maker<M,P,RESP,REQ,IMAT,XMAT>,P extends Promise<RESP,REQ,IMAT,XMAT>,RESP extends Response<RESP,IMAT,XMAT>,REQ extends Request<REQ,IMAT,XMAT>,IMAT extends Identity<IMAT,XMAT>,XMAT extends Context<XMAT>> extends Book<Studio<M,P,RESP,REQ,IMAT,XMAT>,M,Scheduler<M,P,RESP,REQ,IMAT,XMAT>, Identity.Ego, Context.JVM,Scratch<M,P,RESP,REQ,IMAT,XMAT>, Observer<M,P,RESP,REQ,IMAT,XMAT>> {

    public Scratch(Scheduler<M, P, RESP, REQ, IMAT, XMAT> operational) {
        super(operational);
    }
}
