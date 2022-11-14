package dev.inward.matrix.fact.notion.concept;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.notion.Aspect;
import dev.inward.matrix.fact.Specification;
import dev.inward.matrix.resources.Supplier;

public class Effect<F extends Fabrication<F,C,E,V,M>,C extends Concept<C,M>,E extends Effect<F,C,E,V,M>,V extends Volume<F,C,E,V,M>,M extends Mortal<C,M>> extends Aspect<F,C,E,Identity.Ego, Context.Demarc,V,M> {

    public Effect(Specification<C, Identity.Ego, Context.Demarc> specification, Supplier<F, C, E, Identity.Ego, Context.Demarc, V, M, Identity.Ego, Context.Demarc> supplier) {
        super(specification, supplier);
    }
}
