package dev.inward.matrix.datum.fact.notion.concept;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Aspect;
import dev.inward.matrix.operational.Specification;
import dev.inward.matrix.operational.induction.Supplier;

import java.security.ProtectionDomain;

public class Effect<F extends Fabrication<F,C,E,V,M>,C extends Concept<C,M>,E extends Effect<F,C,E,V,M>,V extends Volume<F,C,E,V,M>,M extends Mortal<C,M>> extends Aspect<F,C,E,Identity.Ego,Context.JVM,V,M> {

    public Effect(Specification<C, Identity.Ego, Context.JVM> specification, Supplier<F, C, E, Identity.Ego, Context.JVM, V, M, Identity.Ego, Context.JVM> supplier) {
        super(specification, supplier);
    }
}
