package dev.inward.matrix.fact.notion.interaction;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.notion.house.Assembly;
import dev.inward.matrix.fact.notion.house.Steward;
import dev.inward.matrix.resources.Resource;
import dev.inward.matrix.resources.Storage;
import dev.inward.matrix.fact.notion.Industry;
import dev.inward.matrix.fact.notion.concept.*;
import dev.inward.matrix.fact.notion.concept.corpus.*;
import dev.inward.matrix.fact.matter.Matter;
import dev.inward.matrix.fact.datum.Standard;

import java.util.Map;

public abstract class Handler<H extends Handler<H,A,D,J,P,RESP,REQ,IA,XA>,A extends Interaction<A,RESP,REQ,IA,XA>,D extends Desk<H,A,D,J,P,RESP,REQ,IA,XA>,J extends Journal<H,A,D,J,P,RESP,REQ,IA,XA>,P extends Producer<H,A,D,J,P,RESP,REQ,IA,XA>,RESP extends Matter<RESP,IA,XA>,REQ extends Matter<REQ,IA,XA>,IA extends Identity<IA,XA>,XA extends Context<XA>> extends Industry<H,A,D,Identity.Ego, Context.Ethereal,J,P, Assembly,Corpus,Mechanical,Sandbox, Steward> {

    public Handler(Steward mortal, Storage storage, Map<Standard<?, A, Identity.Ego, Context.Ethereal>, Resource<H, ?, ?, ?, A, D, Identity.Ego, Context.Ethereal, J, P>> standardResourcesMap) {
        super(mortal, storage, standardResourcesMap);
    }
}
