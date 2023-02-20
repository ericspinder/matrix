package dev.inward.matrix.fact.authoritative.notion.interaction;

import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.matter.Matter;
import dev.inward.matrix.fact.authoritative.notion.Omnibus;
import dev.inward.matrix.fact.Context;

public class Journal<H extends Handler<H,A,D,J,P,RESP,REQ,IA,XA>,A extends Interaction<A,RESP,REQ,IA,XA>,D extends Desk<H,A,D,J,P,RESP,REQ,IA,XA>,J extends Journal<H,A,D,J,P,RESP,REQ,IA,XA>,P extends Producer<H,A,D,J,P,RESP,REQ,IA,XA>,RESP extends Matter<RESP,IA,XA>,REQ extends Matter<REQ,IA,XA>,IA extends Identity<IA,XA>,XA extends Context<XA>> extends Omnibus<H,A,D,Identity.Ego, Context.Demarc,J,P> {

    public Journal(D operational) {
        super(operational);
    }
}
