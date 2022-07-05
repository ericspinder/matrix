package dev.inward.matrix.datum.fact.notion.concept;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Resource;
import dev.inward.matrix.datum.fact.Resources;
import dev.inward.matrix.datum.fact.notion.Industry;
import dev.inward.matrix.meta.Standard;

import java.util.Map;

public class Fabrication<FAB extends Fabrication<FAB,C, T,V,M>,C extends Concept<C,M>, T extends Effect<FAB,C, T,V,M>,V extends Volume<FAB,C, T,V,M>,M extends Mortal<FAB,C, T,V,M>> extends Industry<FAB,C, T,Identity.Ego, Context.JVM,V,M,FAB,C, T,V,M> {


    public Fabrication(M mortal, Resources resources, Map<Standard<?, C, Identity.Ego, Context.JVM>, Resource<FAB, ?, ?, ?, C, T, Identity.Ego, Context.JVM, V, M>> standardResourcesMap) {
        super(mortal, resources, standardResourcesMap);
    }

    @Override
    public int compareTo(FAB o) {
        return 0;
    }
}
