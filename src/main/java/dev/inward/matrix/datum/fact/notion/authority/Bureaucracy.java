package dev.inward.matrix.datum.fact.notion.authority;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Resource;
import dev.inward.matrix.datum.fact.notion.Industry;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.corpus.*;
import dev.inward.matrix.meta.Standard;

import java.util.Map;

public class Bureaucracy extends Industry<Bureaucracy,Authority,Court,Identity.SuperEgo, Context.Service,Docket,Judge, Assembly, Corpus, Mechanical, Sandbox, Prophet> {

    public Bureaucracy(Prophet mortal, Map<Standard<?, Authority, Identity.SuperEgo, Context.Service>, Resource<Bureaucracy, ?, ?, ?, Authority, Court, Identity.SuperEgo, Context.Service, Docket, Judge>> standardResourceMap) {
        super(mortal, standardResourceMap);
    }
}
