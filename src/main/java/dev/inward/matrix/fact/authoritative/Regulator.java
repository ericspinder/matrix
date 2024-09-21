package dev.inward.matrix.fact.authoritative;

import dev.inward.matrix.Context;
import dev.inward.matrix.fact.Operational;
import dev.inward.matrix.fact.Specification;

public class Regulator<A extends Tracked<A,I,ID,VERSION,G,EXPIRE>,I extends Identity<I,ID,VERSION,G>,ID extends Comparable<ID>,VERSION extends Comparable<VERSION>,G extends Context.Governance<VERSION,G,EXPIRE>,EXPIRE extends Comparable<EXPIRE>,R extends Regulator<A,I,ID,VERSION,G,EXPIRE,R>> extends Operational<A,I,ID,VERSION,G,R> {



    public Regulator(Zone zone, Specification<F,I,ID,VERSION,G> specification) {
        super();
    }
}
