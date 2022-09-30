package dev.inward.matrix.datum.fact.notion.persona;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Aspect;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.Specification;
import dev.inward.matrix.resources.Supplier;

import java.security.ProtectionDomain;

public class Psyche extends Aspect<Hospitality, Persona,Psyche,Identity.SuperEgo,Context.Service,Skeleton,Spirit> {

    public Psyche(Specification specification, Supplier<Hospitality, Persona, Psyche, Identity.SuperEgo, Context.Service, Skeleton, Spirit, ?, ?> supplier, ProtectionDomain protectionDomain) {
        super(specification, supplier, protectionDomain);
    }
}
