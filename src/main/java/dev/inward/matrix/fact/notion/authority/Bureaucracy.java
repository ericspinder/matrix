package dev.inward.matrix.fact.notion.authority;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.Resource;
import dev.inward.matrix.fact.Resources;
import dev.inward.matrix.fact.notion.Industry;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.notion.concept.corpus.*;
import dev.inward.matrix.meta.Standard;

import java.util.Map;

public class Bureaucracy extends Industry<Bureaucracy,Authority,Court,Identity.SuperEgo, Context.Service,Docket,Judge, Assembly, Corpus, Mechanical, Sandbox, Prophet> {


    public Bureaucracy(Prophet mortal, Resources resources, Map<Standard<?, Authority, Identity.SuperEgo, Context.Service>, Resource<Bureaucracy, ?, ?, ?, Authority, Court, Identity.SuperEgo, Context.Service, Docket, Judge>> standardResourcesMap) {
        super(mortal, resources, standardResourcesMap);
    }
}
