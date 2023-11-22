package dev.inward.matrix.fact.authoritative.notion;


import dev.inward.matrix.Scheme;
import dev.inward.matrix.Library;
import dev.inward.matrix.fact.Factory;
import dev.inward.matrix.Identity;
import dev.inward.matrix.Context;
import dev.inward.matrix.fact.authoritative.notion.concept.Protocol;
import dev.inward.matrix.resources.Resources;
import dev.inward.matrix.resources.Storage;

public class Industry<C extends Protocol<C,D,L,ID,PATH,I,X>,D extends Scheme<C,D,L,ID,PATH,I,X>,L extends Library<C,D,L,ID,PATH,I,X>,ID extends Comparable<ID>,PATH extends Comparable<PATH>,I extends Identity<>,G extends Context.Governance<>,A extends Aspect<N,VERSION,V,ID,EXPIRE,G>> extends Factory<N,V,ID,G,A> {

    protected final Storage<N,S,I,X,O,A> storage;

    public Industry(Resources<N, I, X, R> resources) {
        super(resources);
    }
}
