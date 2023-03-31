package dev.inward.matrix.fact.authoritative.notion;

import dev.inward.matrix.fact.Context;
import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.authoritative.Identity;

public abstract class Notion<N extends Notion<N,VERSION,V,ID,EXPIRE,G>,VERSION extends Comparable<VERSION>,V extends Identity.Versioned<VERSION,V,ID,EXPIRE,G>,ID extends Comparable<ID>,EXPIRE extends Comparable<EXPIRE>,G extends Context.Governance<EXPIRE,G>> extends Fact<N,V,ID,G> {

    public Notion(V id) {
        super(id);
    }

}
