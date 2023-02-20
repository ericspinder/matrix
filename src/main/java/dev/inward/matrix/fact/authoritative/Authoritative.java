package dev.inward.matrix.fact.authoritative;

import dev.inward.matrix.fact.Fact;

public class Authoritative<A extends Authoritative<A,VERSION,V,ID,EXPIRE,G>,VERSION extends Comparable<VERSION>,V extends Identity.Versioned<VERSION,V,ID,G>,ID extends Comparable<ID>,EXPIRE extends Comparable<EXPIRE>,G extends Governance<A,VERSION,V,ID,EXPIRE,G>> extends Fact<A,V,ID,G> {

    Au
    public Authoritative(V id) {
        super(id);
    }
}
