package dev.inward.matrix.datum.fact.notion.authority;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Aspect;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.Specification;
import dev.inward.matrix.resources.Supplier;

import java.security.ProtectionDomain;

public class Court extends Aspect<Bureaucracy,Authority,Court, Identity.SuperEgo, Context.Service,Docket,Judge> {

    public Court(Specification specification, Supplier<Bureaucracy, Authority, Court, Identity.SuperEgo, Context.Service, Docket, Judge, ?, ?> supplier, ProtectionDomain protectionDomain) {
        super(specification, supplier, protectionDomain);
    }
}
