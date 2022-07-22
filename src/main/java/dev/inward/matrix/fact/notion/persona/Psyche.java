package dev.inward.matrix.fact.notion.persona;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.notion.Aspect;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.notion.concept.corpus.Corpus;
import dev.inward.matrix.fact.notion.concept.corpus.Prophet;
import dev.inward.matrix.operational.Specification;
import dev.inward.matrix.operational.Supplier;

import java.security.ProtectionDomain;

public class Psyche extends Aspect<Hospitality,Persona,Psyche,Identity.SuperEgo,Context.Service,Skeleton,Spirit> {

    public Psyche(Specification specification, Supplier<Hospitality, Persona, Psyche, Identity.SuperEgo, Context.Service, Skeleton, Spirit, ?, ?, ?, ?, ?> supplier, ProtectionDomain protectionDomain) {
        super(specification, supplier, protectionDomain);
    }
}
