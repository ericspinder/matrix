package dev.inward.matrix.datum.fact.notion.concept;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Aspect;
import dev.inward.matrix.operational.Specification;
import dev.inward.matrix.operational.induction.Supplier;

import java.security.ProtectionDomain;

public class Effect<F extends Fabrication<F,C,E,V,M>,C extends Concept<C>,E extends Effect<F,C,E,V,M>,V extends Volume<F,C,E,V,M>,M extends Mortal<F,C,E,V,M>> extends Aspect<F,C,E,Identity.Ego,Context.JVM,V,M> {

    public Effect(Specification specification, Supplier<F, C, E, Identity.Ego, Context.JVM, V, M, ?, ?, ?, ?, ?> supplier, ProtectionDomain protectionDomain) {
        super(specification, supplier, protectionDomain);
    }
}
