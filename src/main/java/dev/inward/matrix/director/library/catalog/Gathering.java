package dev.inward.matrix.director.library.catalog;

import dev.inward.matrix.*;
import dev.inward.matrix.fact.*;
import dev.inward.matrix.Dogma;

import java.net.URL;
import java.util.concurrent.locks.StampedLock;

public abstract class Gathering<S extends Scheme<S,L>,L extends Library<S,L>,PATH extends Comparable<PATH>,ID extends Comparable<ID>,T extends Concept.Tangible<S,L,PATH,ID,T,C>,C extends Concept<S,L,PATH,ID,T,C>,CAT extends Catalog<S,L,PATH,ID,T,C,CAT>> {

    private transient final StampedLock gate = new StampedLock();
    protected final CAT catalog;
    protected final Pathway<S,L,PATH> pathway;
    protected final Representative<S,L,PATH,ID,T,C> parent;
    protected final Bus<S,L,PATH,ID,T,C> bus;
    public Gathering(Representative<S,L,PATH,ID,T,C> parent, Pathway<S,L,PATH> pathway, CAT catalog) {
        this.parent = parent;
        this.pathway = pathway;
        this.catalog = catalog;
    }

    public Pathway<S,L,PATH> getPathway() {
        return pathway;
    }

    public CAT getCatalog() {
        return catalog;
    }


    public abstract Representative<S,L,PATH,ID,T,C> registerConcept(C concept);

    public abstract <P extends Profile<S,L,P,U>, U extends Dogma<S,L,U>> boolean evaluateAccess(Profile<S,L,P,U> profile, Context<S,L,PATH,ID,T,C,CAT> context, URL url) throws CheckedException;
    public abstract <P extends Profile<S,L,P,U>, U extends Dogma<S,L,U>> boolean evaluateWrite(Profile<S,L,P,U> profile, Context<S,L,PATH,ID,T,C,CAT> context) throws CheckedException;
    public abstract <P extends Profile<S,L,P,U>, U extends Dogma<S,L,U>> boolean evaluateModify(Profile<S,L,P,U> profile, Context<S,L,PATH,ID,T,C,CAT> context, C concept) throws CheckedException;
    public abstract <P extends Profile<S,L,P,U>, U extends Dogma<S,L,U>> boolean evaluateDelete(Profile<S,L,P,U> profile, Context<S,L,PATH,ID,T,C,CAT> context, C concept) throws CheckedException;

}
