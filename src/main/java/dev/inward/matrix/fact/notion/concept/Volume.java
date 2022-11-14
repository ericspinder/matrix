package dev.inward.matrix.fact.notion.concept;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.notion.Omnibus;

public class Volume<F extends Fabrication<F,C,E,V,M>,C extends Concept<C,M>,E extends Effect<F,C,E,V,M>,V extends Volume<F,C,E,V,M>,M extends Mortal<C,M>> extends Omnibus<F,C,E,Identity.Ego, Context.Demarc,V,M> {

    public Volume(E operational) {
        super(operational);
    }
}
