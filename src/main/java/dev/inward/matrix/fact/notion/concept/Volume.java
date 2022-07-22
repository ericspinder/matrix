package dev.inward.matrix.fact.notion.concept;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.notion.Omnibus;

public class Volume<F extends Fabrication<F,C,E,V,M>,C extends Concept<C,M>,E extends Effect<F,C,E,V,M>,V extends Volume<F,C,E,V,M>,M extends Mortal<F,C,E,V,M>> extends Omnibus<F,C,E,Identity.Ego,Context.JVM,V,M> {

    public Volume(E operational) {
        super(operational);
    }
}
