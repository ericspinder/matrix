package dev.inward.matrix.datum.fact.notion.interaction;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.house.Assembly;
import dev.inward.matrix.datum.fact.notion.house.Prophet;
import dev.inward.matrix.resources.Resource;
import dev.inward.matrix.resources.Storage;
import dev.inward.matrix.datum.fact.notion.Industry;
import dev.inward.matrix.datum.fact.notion.concept.*;
import dev.inward.matrix.datum.fact.notion.concept.corpus.*;
import dev.inward.matrix.matter.Matter;
import dev.inward.matrix.datum.Standard;

import java.util.Map;

public abstract class Handler<H extends Handler<H,A,D,J,P,RESP,REQ,IA,XA>,A extends Interaction<A,RESP,REQ,IA,XA>,D extends Desk<H,A,D,J,P,RESP,REQ,IA,XA>,J extends Journal<H,A,D,J,P,RESP,REQ,IA,XA>,P extends Producer<H,A,D,J,P,RESP,REQ,IA,XA>,RESP extends Matter<RESP,IA,XA>,REQ extends Matter<REQ,IA,XA>,IA extends Identity<IA,XA>,XA extends Context<XA>> extends Industry<H,A,D,Identity.Ego, Context.Demarc,J,P, Assembly,Corpus,Mechanical,Sandbox, Prophet> {

    public Handler(Prophet mortal, Storage storage, Map<Standard<?, A, Identity.Ego, Context.Demarc>, Resource<H, ?, ?, ?, A, D, Identity.Ego, Context.Demarc, J, P>> standardResourcesMap) {
        super(mortal, storage, standardResourcesMap);
    }
}
