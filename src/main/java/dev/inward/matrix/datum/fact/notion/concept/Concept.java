package dev.inward.matrix.datum.fact.notion.concept;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Notion;

public class Concept<C extends Concept<C,M>,M extends Mortal<?,C,?,?,M>> extends Notion<C,Identity.Ego,Context.JVM,M> {

    public Concept(Identity.Ego id) {
        super(id);
    }

}

