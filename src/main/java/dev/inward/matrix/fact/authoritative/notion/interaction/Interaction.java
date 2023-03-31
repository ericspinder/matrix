package dev.inward.matrix.fact.authoritative.notion.interaction;

import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.matter.Matter;
import dev.inward.matrix.fact.authoritative.notion.Notion;
import dev.inward.matrix.fact.Context;

public abstract class Interaction<A extends Interaction<A,RESP,REQ,IA,XA>,RESP extends Matter<RESP,IA,XA>,REQ extends Matter<REQ,IA,XA>,IA extends Identity<IA,XA>,XA extends Context<XA>> extends Notion<A,Identity.Ego, Context.Ethereal> {

    public Interaction(Identity.Ego id) {
        super(id);
    }

    public abstract RESP process(REQ matter);

}
