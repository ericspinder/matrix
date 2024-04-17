package dev.inward.matrix.fact;

import dev.inward.matrix.Scheme;
import dev.inward.matrix.Library;
import dev.inward.matrix.resources.Resource;
import dev.inward.matrix.resources.Resources;

public abstract class Operational<DATUM,S extends Scheme<S,L>,L extends Library<S,L>,PATH extends Comparable<PATH>,ID extends Comparable<ID>,T extends Concept.Tangible<S,L,PATH,ID,T,C>,C extends Concept<S,L,PATH,ID,T,C>> {

    protected final Specification specification;
    protected final Resource<DATUM,S,L,PATH,ID,T,C> resource;
    public Operational(Specification specification,Resource<DATUM,S,L,PATH,ID,T,C> resource) {
        this.specification = specification;
        this.resource = resource;
    }

    public Specification specification() {
        return this.specification;
    }

}
