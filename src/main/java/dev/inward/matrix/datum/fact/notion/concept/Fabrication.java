package dev.inward.matrix.datum.fact.notion.concept;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.resources.Resources;
import dev.inward.matrix.datum.fact.notion.Industry;

public class Fabrication<FAB extends Fabrication<FAB,C,T,V,M>,C extends Concept<C,M>,T extends Effect<FAB,C,T,V,M>,V extends Volume<FAB,C,T,V,M>,M extends Mortal<C,M>> extends Industry<FAB,C,T,Identity.Ego, Context.Ethereal,V,M> {


    public Fabrication(Resources<FAB, C, T, Identity.Ego, Context.Ethereal, V, M, Identity.Ego, Context.Ethereal> resources) {
        super(resources);
    }

    @Override
    public int compareTo(FAB o) {
        return 0;
    }
}
