package dev.inward.matrix.fact.authoritative.notion.authority;

import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.authoritative.notion.Omnibus;
import dev.inward.matrix.fact.Context;

public class Docket extends Omnibus<Bureaucracy,Authority,Court, Identity.SuperEgo, Context.Path,Docket,Judge> {
    public Docket(Court operational) {
        super(operational);
    }
}
