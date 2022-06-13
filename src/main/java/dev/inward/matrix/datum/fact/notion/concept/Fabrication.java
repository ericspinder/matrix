package dev.inward.matrix.datum.fact.notion.concept;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Resources;
import dev.inward.matrix.datum.fact.notion.Industry;
import dev.inward.matrix.meta.Standard;

import java.util.Map;

public class Fabrication<F extends Fabrication<F,C,E,V,M>,C extends Concept<C,M>,E extends Effect<F,C,E,V,M>,V extends Volume<F,C,E,V,M>,M extends Mortal<F,C,E,V,M>> extends Industry<F,C,E,Identity.Ego, Context.JVM,V,M,C,M> {

    public Fabrication(M primogenitor, Map<Standard<?,C,Identity.Ego,Context.JVM>, Resources<F,?,?,?,C,E,Identity.Ego,Context.JVM,V,M>> classResourceMap) {
        super(primogenitor, classResourceMap);
    }

    @Override
    public int compareTo(F o) {
        return 0;
    }
}
