package dev.inward.matrix;

import dev.inward.matrix.director.library.catalog.Ledger;

public abstract class Librarian<PATH extends Comparable<PATH>,X extends Context<PATH,X,ID,I,C,R>,ID extends Comparable<ID>,I extends Concept.Identity<PATH,X,ID,I,C,R>,C extends Concept<PATH,X,ID,I,C,R>,R extends Representitive<PATH,X,ID,I,C,R>> {

    protected final Ledger<PATH> ledger;
    protected Concept.Resource<PATH,D,ID,T,C,R> resource;

    public Librarian(Ledger<PATH,D> ledger, Concept.Resource<PATH,D,ID,T,C,R> resource) {
        this.ledger = ledger;
        this.resource = resource;
    }

    public Ledger<PATH, D> getCatalog() {
        return ledger;
    }

    public Concept.Resource<PATH,D,ID,T,C,R> getResource() {
        return this.resource;
    }
}
