package dev.inward.matrix.fact.authoritative.notion.interaction;

import dev.inward.matrix.fact.Model;
import dev.inward.matrix.Identity;
import dev.inward.matrix.fact.matter.Matter;
import dev.inward.matrix.Context;

import java.lang.ref.ReferenceQueue;


public class Producer<H extends Handler<H,A,D,J,P,RESP,REQ,IA,XA>,A extends Interaction<A,RESP,REQ,IA,XA>,D extends Desk<H,A,D,J,P,RESP,REQ,IA,XA>,J extends Journal<H,A,D,J,P,RESP,REQ,IA,XA>,P extends Producer<H,A,D,J,P,RESP,REQ,IA,XA>,RESP extends Matter<RESP,IA,XA>,REQ extends Matter<REQ,IA,XA>,IA extends Identity<IA,XA>,XA extends Context<XA>> extends Model<H, A, D, Identity.Ego, Context.Demarc, J, P> {

    public Producer(A fact, ReferenceQueue<A> referenceQueue, J omnibus, D aspect) {
        super(fact, referenceQueue, omnibus, aspect);
    }
}

