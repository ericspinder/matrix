package dev.inward.matrix.datum.fact.notion.interaction;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Omnibus;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.matter.Matter;

public class Journal<H extends Handler<H,A,D,J,P,RESP,REQ,IA,XA>,A extends Interaction<A,RESP,REQ,IA,XA>,D extends Desk<H,A,D,J,P,RESP,REQ,IA,XA>,J extends Journal<H,A,D,J,P,RESP,REQ,IA,XA>,P extends Producer<H,A,D,J,P,RESP,REQ,IA,XA>,RESP extends Matter<RESP,IA,XA>,REQ extends Matter<REQ,IA,XA>,IA extends Identity<IA,XA>,XA extends Context<XA>> extends Omnibus<H,A,D,Identity.Ego, Context.Demarc,J,P> {

    public Journal(D operational) {
        super(operational);
    }
}
