package dev.inward.matrix.fact.intialized.maker;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.intialized.Functionary;
import dev.inward.matrix.matter.Promise;
import dev.inward.matrix.matter.Request;
import dev.inward.matrix.matter.Response;
import dev.inward.matrix.operational.Specification;
import dev.inward.matrix.operational.Supplier;

import java.security.ProtectionDomain;

public class Scheduler<M extends Maker<M,P,RESP,REQ,IMAT,XMAT>,P extends Promise<RESP,REQ,IMAT,XMAT>,RESP extends Response<RESP,IMAT,XMAT>,REQ extends Request<REQ,IMAT,XMAT>,IMAT extends Identity<IMAT,XMAT>,XMAT extends Context<XMAT>> extends Functionary<Studio<M,P,RESP,REQ,IMAT,XMAT>,M,Scheduler<M,P,RESP,REQ,IMAT,XMAT>, Identity.Ego, Context.JVM,Scratch<M,P,RESP,REQ,IMAT,XMAT>, Observer<M,P,RESP,REQ,IMAT,XMAT>> {

    public Scheduler(Specification specification, Supplier<Studio<M, P, RESP, REQ, IMAT, XMAT>, M, Scheduler<M, P, RESP, REQ, IMAT, XMAT>, Identity.Ego, Context.JVM, Scratch<M, P, RESP, REQ, IMAT, XMAT>, Observer<M, P, RESP, REQ, IMAT, XMAT>, ?, ?, ?, ?, ?> supplier, ProtectionDomain protectionDomain) {
        super(specification, supplier, protectionDomain);
    }
}
