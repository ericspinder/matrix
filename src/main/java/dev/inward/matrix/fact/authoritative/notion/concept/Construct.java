package dev.inward.matrix.fact.authoritative.notion.concept;

import dev.inward.matrix.*;
import dev.inward.matrix.authority.Domain;
import dev.inward.matrix.authority.dns.Terrene;
import dev.inward.matrix.Range;

public abstract class Construct<PATH extends Comparable<PATH>> extends Library<Matrix<PATH>,Construct<PATH>, Range<PATH>> {

    public Construct(Matrix matrix, Terrene terrene, Domain domain) {
        super(matrix, terrene, domain);
    }

    @Override
    public int compareTo(Construct o) {
        return 0;
    }

//    public boolean matter(Identity.Ego reporter, Matter<?,?,?> matter) {
//        reporter.getContext().getAuthority().
//    }
}
