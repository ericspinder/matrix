package dev.inward.matrix.fact.authoritative.notion.authority;

import dev.inward.matrix.Host;
import dev.inward.matrix.Identity;
import dev.inward.matrix.fact.authoritative.notion.Omnibus;
import dev.inward.matrix.Context;

public class Docket extends Omnibus<Bureaucracy, Host,Court, Identity.Gate, Context.Path,Docket,Judge> {
    public Docket(Court operational) {
        super(operational);
    }
}
