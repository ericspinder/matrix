package dev.inward.matrix.fact.authoritative.notion.concept;

import crud.Protocol;
import crud.Volume;
import dev.inward.matrix.Context;
import dev.inward.matrix.Identity;
import dev.inward.matrix.fact.authoritative.notion.Industry;
import dev.inward.matrix.resources.Storage;

public class Fabrication<FAB extends Fabrication<FAB,C,T,V,M>,C extends Protocol<C,M>,T extends Effect<FAB,C,T,V,M>,V extends Volume<FAB,C,T,V,M>,M extends Construct<C,M>> extends Industry<FAB,C,T,Identity.Ego, Context.Demarc,V,M> {


    public Fabrication(Storage<FAB, C, T, Identity.Ego, Context.Demarc, V, M, Identity.Ego, Context.Demarc> storage) {
        super(storage);
    }

    @Override
    public int compareTo(FAB o) {
        return 0;
    }
}
