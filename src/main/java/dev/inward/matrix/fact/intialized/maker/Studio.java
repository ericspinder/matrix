package dev.inward.matrix.fact.intialized.maker;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.Resource;
import dev.inward.matrix.fact.Resources;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.notion.concept.corpus.*;
import dev.inward.matrix.fact.intialized.Manager;
import dev.inward.matrix.matter.Promise;
import dev.inward.matrix.matter.Request;
import dev.inward.matrix.matter.Response;
import dev.inward.matrix.meta.Standard;

import java.util.Map;

public class Studio<M extends Maker<M,P,RESP,REQ,IMAT,XMAT>,P extends Promise<RESP,REQ,IMAT,XMAT>,RESP extends Response<RESP,IMAT,XMAT>,REQ extends Request<REQ,IMAT,XMAT>,IMAT extends Identity<IMAT,XMAT>,XMAT extends Context<XMAT>> extends Manager<Studio<M,P,RESP,REQ,IMAT,XMAT>,M,Scheduler<M,P,RESP,REQ,IMAT,XMAT>, Identity.Ego, Context.JVM,Scratch<M,P,RESP,REQ,IMAT,XMAT>, Observer<M,P,RESP,REQ,IMAT,XMAT>,Assembly,Corpus,Mechanical,Sandbox, Prophet> {


    public Studio(Prophet mortal, Resources resources, Map<Standard<?, M, Identity.Ego, Context.JVM>, Resource<Studio<M, P, RESP, REQ, IMAT, XMAT>, ?, ?, ?, M, Scheduler<M, P, RESP, REQ, IMAT, XMAT>, Identity.Ego, Context.JVM, Scratch<M, P, RESP, REQ, IMAT, XMAT>, Observer<M, P, RESP, REQ, IMAT, XMAT>>> standardResourcesMap) {
        super(mortal, resources, standardResourcesMap);
    }
}
