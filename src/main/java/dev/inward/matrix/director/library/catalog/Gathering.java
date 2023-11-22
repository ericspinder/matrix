package dev.inward.matrix.director.library.catalog;

import dev.inward.matrix.*;
import dev.inward.matrix.director.library.Memory;
import dev.inward.matrix.fact.*;
import dev.inward.matrix.fact.authoritative.notion.Notion;
import dev.inward.matrix.fact.datum.User;

import java.net.URL;
import java.util.concurrent.locks.StampedLock;

public abstract class Gathering<S extends Scheme<S,L>,L extends Library<S,L>,PATH extends Comparable<PATH>,ID extends Comparable<ID>,T extends Identity.Tangible<S,L,PATH,ID,T,C>,C extends Concept<S,L,PATH,ID,T,C>,CAT extends Catalog<S,L,PATH,ID,T,C,CAT>> {

    private transient final StampedLock gate = new StampedLock();
    protected final CAT catalog;
    protected final Representative<S,L,PATH,ID,T,C> parent;
    public Gathering(Representative<S,L,PATH,ID,T,C> parent, CAT catalog) {
        this.parent = parent;
        this.catalog = catalog;
    }

    public CAT getCatalog() {
        return catalog;
    }

    public abstract Representative<S,L,PATH,ID,T,C> registerConcept(C concept);

    public abstract <P extends Profile<S,L,P,U>, U extends User<S,L,U>> boolean evaluateAccess(Profile<S,L,P,U> profile, Context<S,L,PATH,ID,T,C,CAT> context, URL url) throws CheckedException;
    public abstract <P extends Profile<S,L,P,U>, U extends User<S,L,U>> boolean evaluateWrite(Profile<S,L,P,U> profile,Context<S,L,PATH,ID,T,C,CAT> context) throws CheckedException;
    public abstract <P extends Profile<S,L,P,U>, U extends User<S,L,U>> boolean evaluateModify(Profile<S,L,P,U> profile,Context<S,L,PATH,ID,T,C,CAT> context,C concept) throws CheckedException;
    public abstract <P extends Profile<S,L,P,U>, U extends User<S,L,U>> boolean evaluateDelete(Profile<S,L,P,U> profile,Context<S,L,PATH,ID,T,C,CAT> context,C concept) throws CheckedException;

}
