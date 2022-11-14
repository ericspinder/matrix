package dev.inward.matrix.fact.notion.concept;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.notion.Notion;

public class Concept<C extends Concept<C,M>,M extends Mortal<C,M>> extends Notion<C,Identity.Ego, Context.Demarc,M> {

    public Concept(Identity.Ego id) {
        super(id);
    }

}

