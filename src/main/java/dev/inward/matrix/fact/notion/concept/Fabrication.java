package dev.inward.matrix.fact.notion.concept;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.resources.Storage;
import dev.inward.matrix.fact.notion.Industry;

public class Fabrication<FAB extends Fabrication<FAB,C,T,V,M>,C extends Concept<C,M>,T extends Effect<FAB,C,T,V,M>,V extends Volume<FAB,C,T,V,M>,M extends Mortal<C,M>> extends Industry<FAB,C,T,Identity.Ego, Context.Demarc,V,M> {


    public Fabrication(Storage<FAB, C, T, Identity.Ego, Context.Demarc, V, M, Identity.Ego, Context.Demarc> storage) {
        super(storage);
    }

    @Override
    public int compareTo(FAB o) {
        return 0;
    }
}
