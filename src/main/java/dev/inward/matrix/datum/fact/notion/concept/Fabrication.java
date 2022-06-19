package dev.inward.matrix.datum.fact.notion.concept;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Resource;
import dev.inward.matrix.datum.fact.notion.Industry;
import dev.inward.matrix.meta.Standard;

import java.util.Map;

public class Fabrication<FAB extends Fabrication<FAB,C,E,V,M>,C extends Concept<C,M>,E extends Effect<FAB,C,E,V,M>,V extends Volume<FAB,C,E,V,M>,M extends Mortal<FAB,C,E,V,M>> extends Industry<FAB,C,E,Identity.Ego, Context.JVM,V,M,FAB,C,E,V,M> {

    public Fabrication(M primogenitor, Map<Standard<?,C,Identity.Ego,Context.JVM>, Resource<FAB,?,?,?,C,E,Identity.Ego,Context.JVM,V,M>> classResourceMap) {
        super(primogenitor, classResourceMap);
    }

    @Override
    public int compareTo(FAB o) {
        return 0;
    }
}
