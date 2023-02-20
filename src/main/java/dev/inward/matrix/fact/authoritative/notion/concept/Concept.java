package dev.inward.matrix.fact.authoritative.notion.concept;

import dev.inward.matrix.fact.authoritative.Governance;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.authoritative.notion.Notion;

public class Concept<C extends Concept<C,M>,M extends Mortal<C,M>> extends Notion<C,Identity.Ego, Governance.Ethereal,M> {

    public Concept(Identity.Ego id) {
        super(id);
    }

}

