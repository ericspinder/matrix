package dev.inward.matrix.datum.fact.notion.interaction;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.matter.Matter;

public abstract class Interaction<A extends Interaction<A,RESP,REQ,IA,XA>,RESP extends Matter<RESP,IA,XA>,REQ extends Matter<REQ,IA,XA>,IA extends Identity<IA,XA>,XA extends Context<XA>> extends Notion<A,Identity.Ego, Context.Ethereal> {

    public Interaction(Identity.Ego id) {
        super(id);
    }

    public abstract RESP process(REQ matter);

}
