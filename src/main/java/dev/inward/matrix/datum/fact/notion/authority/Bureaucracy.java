package dev.inward.matrix.datum.fact.notion.authority;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.resources.Resources;
import dev.inward.matrix.datum.fact.notion.Industry;
import dev.inward.matrix.datum.fact.notion.concept.Context;

public class Bureaucracy extends Industry<Bureaucracy,Authority,Court,Identity.SuperEgo,Context.Service,Docket,Judge> {
    public Bureaucracy(Resources<Bureaucracy, Authority, Court, Identity.SuperEgo, Context.Service, Docket, Judge, Identity.SuperEgo, Context.Service> resources) {
        super(resources);
    }
}
