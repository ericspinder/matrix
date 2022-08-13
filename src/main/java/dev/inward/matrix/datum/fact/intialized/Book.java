package dev.inward.matrix.datum.fact.intialized;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Bus;
import dev.inward.matrix.datum.fact.notion.concept.*;

public class Book<S extends Manager<S,P,U,I,X,K,L,?,?,?,?,?>,P extends Intialized<P,I,X>,U extends Functionary<S,P,U,I,X,K,L>,I extends Identity<I,X>,X extends Context<X>,K extends Book<S,P,U,I,X,K,L>,L extends Delegated<S,P,U,I,X,K,L>> extends Bus<S,P,U,I,X,K,L> {

    public Book(U operational) {
        super(operational);
    }
}

