package dev.inward.matrix.fact.authoritative.notion.authority;

import dev.inward.matrix.fact.Specification;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.authoritative.notion.Aspect;
import dev.inward.matrix.fact.Context;
import dev.inward.matrix.resources.Supplier;

import java.security.ProtectionDomain;

public class Court extends Aspect<Bureaucracy,Authority,Court, Identity.SuperEgo, Context.Path,Docket,Judge> {

    public Court(Specification specification, Supplier<Bureaucracy, Authority, Court, Identity.SuperEgo, Context.Path, Docket, Judge, ?, ?> supplier, ProtectionDomain protectionDomain) {
        super(specification, supplier, protectionDomain);
    }
}
