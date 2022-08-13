package dev.inward.matrix.datum.fact.notion.interaction;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.operational.induction.Resource;
import dev.inward.matrix.operational.induction.Resources;
import dev.inward.matrix.datum.fact.notion.Industry;
import dev.inward.matrix.datum.fact.notion.concept.*;
import dev.inward.matrix.datum.fact.notion.concept.corpus.*;
import dev.inward.matrix.matter.Matter;
import dev.inward.matrix.meta.Standard;

import java.util.Map;

public abstract class Handler<H extends Handler<H,A,D,J,P,RESP,REQ,IA,XA>,A extends Interaction<A,RESP,REQ,IA,XA>,D extends Desk<H,A,D,J,P,RESP,REQ,IA,XA>,J extends Journal<H,A,D,J,P,RESP,REQ,IA,XA>,P extends Producer<H,A,D,J,P,RESP,REQ,IA,XA>,RESP extends Matter<RESP,IA,XA>,REQ extends Matter<REQ,IA,XA>,IA extends Identity<IA,XA>,XA extends Context<XA>> extends Industry<H,A,D,Identity.Ego,Context.JVM,J,P,Assembly,Corpus,Mechanical,Sandbox,Prophet> {

    public Handler(Prophet mortal, Resources resources, Map<Standard<?, A, Identity.Ego, Context.JVM>, Resource<H, ?, ?, ?, A, D, Identity.Ego, Context.JVM, J, P>> standardResourcesMap) {
        super(mortal, resources, standardResourcesMap);
    }
}
