package dev.inward.matrix.fact.authoritative.notion;


import dev.inward.matrix.fact.Factory;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.Context;
import dev.inward.matrix.resources.Resources;
import dev.inward.matrix.resources.Storage;

public class Industry<N extends Notion<N,VERSION,V,ID,EXPIRE,G>,VERSION extends Comparable<VERSION>,V extends Identity.Versioned<VERSION,V,ID,EXPIRE,G>,ID extends Comparable<ID>,EXPIRE extends Comparable<EXPIRE>,G extends Context.Governance<EXPIRE,G>,A extends Aspect<N,VERSION,V,ID,EXPIRE,G>> extends Factory<N,V,ID,G,A> {

    protected final Storage<N,S,I,X,O,A> storage;

    public Industry(Resources<N, I, X, R> resources) {
        super(resources);
    }
}
