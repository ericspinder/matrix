package dev.inward.matrix.datum.fact.notion.concept;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Aspect;
import dev.inward.matrix.datum.fact.Specification;
import dev.inward.matrix.resources.Supplier;

public class Effect<F extends Fabrication<F,C,E,V,M>,C extends Concept<C,M>,E extends Effect<F,C,E,V,M>,V extends Volume<F,C,E,V,M>,M extends Mortal<C,M>> extends Aspect<F,C,E,Identity.Ego, Context.Ethereal,V,M> {

    public Effect(Specification<C, Identity.Ego, Context.Ethereal> specification, Supplier<F, C, E, Identity.Ego, Context.Ethereal, V, M, Identity.Ego, Context.Ethereal> supplier) {
        super(specification, supplier);
    }
}
