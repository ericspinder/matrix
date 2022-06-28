package dev.inward.matrix.datum.fact.notion.authority;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Aspect;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.operational.Options;
import dev.inward.matrix.operational.Supplier;

public class Court extends Aspect<Bureaucracy,Authority,Court, Identity.SuperEgo, Context.Service,Docket,Judge> {
    public Court(Options options, Supplier<Bureaucracy, Authority, Court, Identity.SuperEgo, Context.Service, Docket, Judge, ?, ?, ?, ?, ?> supplier) {
        super(options, supplier);
    }
}
