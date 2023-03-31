package dev.inward.matrix.fact.authoritative.notion;

import dev.inward.matrix.engine.Memory;
import dev.inward.matrix.engine.Zone;
import dev.inward.matrix.fact.Operational;
import dev.inward.matrix.fact.Specification;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.Context;
import dev.inward.matrix.resources.Supplier;

public class Aspect<N extends Notion<N,VERSION,V,ID,EXPIRE,G>,VERSION extends Comparable<VERSION>,V extends Identity.Versioned<VERSION,V,ID,EXPIRE,G>,ID extends Comparable<ID>,EXPIRE extends Comparable<EXPIRE>,G extends Context.Governance<EXPIRE,G>> extends Operational<N,V,ID,G> {

    protected final Memory<N,> notionsInMemory = new Memory();

    public Aspect(Zone zone, Specification<N, I, X> specification, Supplier<Y, N, S, I, X, O, A, N, I, X, A> supplier) {
        super(zone, specification, supplier);
    }
}

