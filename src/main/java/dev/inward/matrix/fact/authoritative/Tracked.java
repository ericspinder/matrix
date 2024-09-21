package dev.inward.matrix.fact.authoritative;

import dev.inward.matrix.Context;
import dev.inward.matrix.fact.Fact;

public class Tracked<T extends Tracked<T,VERSION,V,ID,EXPIRE,G>,VERSION extends Comparable<VERSION>,V extends Identity.Versioned<T,VERSION,V,ID,EXPIRE,G>,ID extends Comparable<ID>,EXPIRE extends Comparable<EXPIRE>,G extends Context.Governance<T,VERSION,V,ID,EXPIRE,G>> extends Fact<T,V,ID,G> {


    public Tracked(V id) {
        super(id);
    }
}
