package dev.inward.matrix.datum.fact.notion.authority;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.operational.induction.Resource;
import dev.inward.matrix.operational.induction.Resources;
import dev.inward.matrix.datum.fact.notion.Industry;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.corpus.*;
import dev.inward.matrix.meta.Standard;

import java.util.Map;

public class Bureaucracy extends Industry<Bureaucracy,Authority,Court,Identity.SuperEgo,Context.Service,Docket,Judge> {
    public Bureaucracy(Resources<Bureaucracy, Authority, Court, Identity.SuperEgo, Context.Service, Docket, Judge, Identity.SuperEgo, Context.Service> resources) {
        super(resources);
    }
}
