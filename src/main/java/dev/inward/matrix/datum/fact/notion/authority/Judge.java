package dev.inward.matrix.datum.fact.notion.authority;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Ambassador;
import dev.inward.matrix.datum.fact.notion.concept.Context;

import java.lang.ref.ReferenceQueue;

public class Judge extends Ambassador<Bureaucracy,Authority,Court, Identity.SuperEgo, Context.Service,Docket,Judge> {
    public Judge(Authority fact, ReferenceQueue<Authority> referenceQueue, Docket omnibus, Court aspect) {
        super(fact, referenceQueue, omnibus, aspect);
    }
}
