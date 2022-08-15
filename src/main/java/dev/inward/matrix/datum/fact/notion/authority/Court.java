package dev.inward.matrix.datum.fact.notion.authority;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Aspect;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.operational.Specification;
import dev.inward.matrix.operational.induction.Supplier;

import java.security.ProtectionDomain;

public class Court extends Aspect<Bureaucracy,Authority,Court, Identity.SuperEgo, Context.Service,Docket,Judge> {

    public Court(Specification specification, Supplier<Bureaucracy, Authority, Court, Identity.SuperEgo, Context.Service, Docket, Judge, ?, ?> supplier, ProtectionDomain protectionDomain) {
        super(specification, supplier, protectionDomain);
    }
}
