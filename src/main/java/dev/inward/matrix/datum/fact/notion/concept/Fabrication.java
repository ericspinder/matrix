package dev.inward.matrix.datum.fact.notion.concept;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Resource;
import dev.inward.matrix.datum.fact.notion.Industry;

import java.util.Map;

public class Fabrication<F extends Fabrication<F,C,E,X,V,M>,C extends Concept<C,X,M>,E extends Effect<F,C,E,X,V,M>,X extends Context.Platform<X>,V extends Volume<F,C,E,X,V,M>,M extends Mortal<F,C,E,X,V,M>> extends Industry<F,C,E,Identity.Ego<X>,X,V,M> {

    public Fabrication(M primogenitor, Map<Class<?>, Resource<F, ?, C, E, Identity.Ego<X>, X, V, M, C, M, ?>> classResourceMap) {
        super(primogenitor, classResourceMap);
    }

    @Override
    public int compareTo(F o) {
        return 0;
    }
}
