package dev.inward.matrix.datum.fact.notion.concept;

import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.Identity;

public class Concept<C extends Concept<C,X,IM>,X extends Context.Platform<X>,IM extends Immortal<?,C,?,X,?,IM>> extends Notion<C, Identity.SuperEgo<X>,X,IM> {

    public Concept(Identity.SuperEgo<X> id) {
        super(id);
    }

}

