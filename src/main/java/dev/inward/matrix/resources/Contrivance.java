package dev.inward.matrix.resources;

import dev.inward.matrix.Library;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.fact.Concept;
import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.policy.Policy;

public class Contrivance<S extends Scheme<S,L>,L extends Library<S,L>,PATH extends Comparable<PATH>,ID extends Comparable<ID>,T extends Concept.Tangible<S,L,PATH,ID,T,C>,C extends Concept<S,L,PATH,ID,T,C>,N extends Fact.Named<S,L,N,F>,F extends Fact<S,L,N,F>> extends Resource<C,S,L,N,F> {

    public Contrivance(L library, String className, Policy[] policies, long warnOnTotal) {
        super(library, className, policies, warnOnTotal);
    }
}
