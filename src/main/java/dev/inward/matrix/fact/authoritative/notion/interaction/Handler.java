package dev.inward.matrix.fact.authoritative.notion.interaction;

import dev.inward.matrix.Standard;
import dev.inward.matrix.concept.matter.Matter;
import dev.inward.matrix.fact.authoritative.notion.Industry;
import dev.inward.matrix.Context;
import dev.inward.matrix.fact.authoritative.notion.concept.corpus.Corpus;
import dev.inward.matrix.fact.authoritative.notion.concept.corpus.Mechanical;
import dev.inward.matrix.fact.authoritative.notion.concept.corpus.Sandbox;
import dev.inward.matrix.fact.authoritative.notion.house.Assembly;
import dev.inward.matrix.fact.authoritative.notion.house.Steward;
import dev.inward.matrix.Resource;
import dev.inward.matrix.resources.Storage;

import java.util.Map;

public abstract class Handler<H extends Handler<H,A,D,J,P,RESP,REQ,IA,XA>,A extends Interaction<A,RESP,REQ,IA,XA>,D extends Desk<H,A,D,J,P,RESP,REQ,IA,XA>,J extends Journal<H,A,D,J,P,RESP,REQ,IA,XA>,P extends Producer<H,A,D,J,P,RESP,REQ,IA,XA>,RESP extends Matter<RESP,IA,XA>,REQ extends Matter<REQ,IA,XA>,IA extends Identity<IA,XA>,XA extends Context<XA>> extends Industry<H,A,D,Identity.Ego, Context.Ethereal,J,P, Assembly,Corpus,Mechanical,Sandbox, Steward> {

    public Handler(Steward mortal, Storage storage, Map<Standard<?, A, Identity.Ego, Context.Ethereal>, Resource<H, ?, ?, ?, A, D, Identity.Ego, Context.Ethereal, J, P>> standardResourcesMap) {
        super(mortal, storage, standardResourcesMap);
    }
}
