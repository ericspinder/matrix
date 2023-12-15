package dev.inward.matrix.fact;

import dev.inward.matrix.Scheme;
import dev.inward.matrix.Identity;
import dev.inward.matrix.Library;
import dev.inward.matrix.resources.Resources;

public abstract class Operational<S extends Scheme<S,L>,L extends Library<S,L>,PATH extends Comparable<PATH>,ID extends Comparable<ID>,T extends Identity.Tangible<S,L,PATH,ID,T,C>,C extends Concept<S,L,PATH,ID,T,C>,O extends Operational<S,L,PATH,ID,T,C,O>> {

    protected final Specification specification;
    protected final Resources<S,L,PATH,ID,T,C> resources;
    public Operational(Specification specification,Resources<S,L,PATH,ID,I,C,N> resources) {
        this.specification = specification;
        this.resources = resources;
    }

    public Specification specification() {
        return this.specification;
    }

}
