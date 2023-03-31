package dev.inward.matrix.fact;

import com.google.common.collect.Ordering;
import dev.inward.matrix.engine.Zone;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.authoritative.Reaper;

public class Operational<F extends Fact<F,I,ID,X>,I extends Identity<I,ID,X>,ID extends Comparable<ID>,X extends Context<X>> {

    protected final Specification<F,I,ID,X> specification;

    public Operational(Zone zone, Specification<F,I,ID,X> specification) {
        this.specification = specification;
    }

    public Specification<F,I,ID,X> specification() {
        return this.specification;
    }

}
