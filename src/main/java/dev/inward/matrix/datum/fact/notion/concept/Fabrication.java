package dev.inward.matrix.datum.fact.notion.concept;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.operational.induction.Resource;
import dev.inward.matrix.operational.induction.Resources;
import dev.inward.matrix.datum.fact.notion.Industry;
import dev.inward.matrix.standard.Standard;

import java.util.Map;

public class Fabrication<FAB extends Fabrication<FAB,C,T,V,M>,C extends Concept<C,M>,T extends Effect<FAB,C,T,V,M>,V extends Volume<FAB,C,T,V,M>,M extends Mortal<C,M>> extends Industry<FAB,C,T,Identity.Ego, Context.JVM,V,M> {


    public Fabrication(Resources<FAB, C, T, Identity.Ego, Context.JVM, V, M, Identity.Ego, Context.JVM> resources) {
        super(resources);
    }

    @Override
    public int compareTo(FAB o) {
        return 0;
    }
}
