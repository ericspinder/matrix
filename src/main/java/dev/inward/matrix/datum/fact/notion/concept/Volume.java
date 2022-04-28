package dev.inward.matrix.datum.fact.notion.concept;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Omnibus;
import dev.inward.matrix.rubric.Criteria;
import dev.inward.matrix.rubric.Criterion;

import java.util.Map;

public class Volume<F extends Fabrication<F,C,E,X,V,M>,C extends Concept<C,X,M>,E extends Effect<F,C,E,X,V,M>,X extends Context.Platform<X>,V extends Volume<F,C,E,X,V,M>,M extends Mortal<F,C,E,X,V,M>> extends Omnibus<F,C,E,Identity.Ego<X>,X,V,M> {
    public Volume(E operational, Map<Criteria, Criterion[]> criteriaMap) {
        super(operational, criteriaMap);
    }
}
