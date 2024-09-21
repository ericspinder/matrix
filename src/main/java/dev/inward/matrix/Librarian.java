package dev.inward.matrix;

import dev.inward.matrix.director.library.catalog.Catalog;
import dev.inward.matrix.fact.Concept;

public abstract class Librarian<P extends Pathway<P,CAT>,ID extends Comparable<ID>,T extends Concept.Tangible<P,ID,T,C,CAT>,C extends Concept<P,ID,T,C,CAT>,CAT extends Catalog<P,CAT>> implements Comparable<Librarian<P,ID,T,C,CAT>> {

    protected final Library<?> library;
    protected Concept.Resource<P,ID,T,C,CAT> resource;

    public Librarian(Library<?> library, Concept.Resource<P,ID,T,C,CAT> resource) {
        this.library = library;
        this.resource = resource;
    }

    public Range<PATH> getRange() {
        return range;
    }

    @Override
    public int compareTo(B that) {
        return 0;
    }
}
