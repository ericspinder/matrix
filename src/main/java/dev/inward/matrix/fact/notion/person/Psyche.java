package dev.inward.matrix.fact.notion.person;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.notion.Aspect;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.Specification;
import dev.inward.matrix.personality.Persona;
import dev.inward.matrix.resources.Supplier;

import java.security.ProtectionDomain;

public class Psyche extends Aspect<Hospitality, Persona,Psyche,Identity.SuperEgo,Context.Service,Skeleton,Spirit> {

    public Psyche(Specification specification, Supplier<Hospitality, Persona, Psyche, Identity.SuperEgo, Context.Service, Skeleton, Spirit, ?, ?> supplier, ProtectionDomain protectionDomain) {
        super(specification, supplier, protectionDomain);
    }
}
