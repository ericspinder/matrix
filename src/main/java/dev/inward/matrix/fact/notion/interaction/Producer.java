package dev.inward.matrix.fact.notion.interaction;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.notion.Ambassador;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.matter.Matter;

import java.lang.ref.ReferenceQueue;


public class Producer<H extends Handler<H,A,D,J,P,RESP,REQ,IA,XA>,A extends Interaction<A,RESP,REQ,IA,XA>,D extends Desk<H,A,D,J,P,RESP,REQ,IA,XA>,J extends Journal<H,A,D,J,P,RESP,REQ,IA,XA>,P extends Producer<H,A,D,J,P,RESP,REQ,IA,XA>,RESP extends Matter<RESP,IA,XA>,REQ extends Matter<REQ,IA,XA>,IA extends Identity<IA,XA>,XA extends Context<XA>> extends Ambassador<H,A,D,Identity.Ego,Context.JVM,J, P> {

    public Producer(A fact, ReferenceQueue<A> referenceQueue, J omnibus, D aspect) {
        super(fact, referenceQueue, omnibus, aspect);
    }
}

