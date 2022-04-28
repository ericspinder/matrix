package dev.inward.matrix.datum.fact.notion.concept;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Notion;

public class Concept<C extends Concept<C,X,M>,X extends Context.Platform<X>,M extends Mortal<?,C,?,X,?,M>> extends Notion<C,Identity.Ego<X>,X,M> {

    public Concept(Identity.Ego<X> id) {
        super(id);
    }

}

