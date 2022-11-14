package dev.inward.matrix.fact.notion.interaction;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.notion.Aspect;
import dev.inward.matrix.fact.notion.concept.*;
import dev.inward.matrix.fact.matter.Matter;
import dev.inward.matrix.fact.Specification;
import dev.inward.matrix.resources.Supplier;

import java.security.ProtectionDomain;


public class Desk<H extends Handler<H,A,D,J,P,RESP,REQ,IA,XA>,A extends Interaction<A,RESP,REQ,IA,XA>,D extends Desk<H,A,D,J,P,RESP,REQ,IA,XA>,J extends Journal<H,A,D,J,P,RESP,REQ,IA,XA>,P extends Producer<H,A,D,J,P,RESP,REQ,IA,XA>,RESP extends Matter<RESP,IA,XA>,REQ extends Matter<REQ,IA,XA>,IA extends Identity<IA,XA>,XA extends Context<XA>> extends Aspect<H,A,D,Identity.Ego, Context.Demarc,J,P> {

    public Desk(Specification specification, Supplier<H, A, D, Identity.Ego, Context.Demarc, J, P, ?, ?, ?, ?, ?> supplier, ProtectionDomain protectionDomain) {
        super(specification, supplier, protectionDomain);
    }
}
