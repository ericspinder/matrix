package dev.inward.matrix.datum.fact.notion.authority;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Omnibus;
import dev.inward.matrix.datum.fact.notion.concept.Context;

public class Docket extends Omnibus<Bureaucracy,Authority,Court, Identity.SuperEgo, Context.Service,Docket,Judge> {
    public Docket(Court operational) {
        super(operational);
    }
}
