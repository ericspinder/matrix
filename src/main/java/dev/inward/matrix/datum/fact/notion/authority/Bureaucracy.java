package dev.inward.matrix.datum.fact.notion.authority;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.resources.Storage;
import dev.inward.matrix.datum.fact.notion.Industry;
import dev.inward.matrix.datum.fact.notion.concept.Context;

public class Bureaucracy extends Industry<Bureaucracy,Authority,Court,Identity.SuperEgo,Context.Service,Docket,Judge> {
    public Bureaucracy(Storage<Bureaucracy, Authority, Court, Identity.SuperEgo, Context.Service, Docket, Judge, Identity.SuperEgo, Context.Service> storage) {
        super(storage);
    }
}
