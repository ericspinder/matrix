package dev.inward.matrix.fact.notion.authority;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.notion.Omnibus;
import dev.inward.matrix.fact.notion.concept.Context;

public class Docket extends Omnibus<Bureaucracy,Authority,Court, Identity.SuperEgo, Context.Service,Docket,Judge> {
    public Docket(Court operational) {
        super(operational);
    }
}
