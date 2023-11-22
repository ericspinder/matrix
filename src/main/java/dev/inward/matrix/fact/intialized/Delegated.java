package dev.inward.matrix.fact.intialized;

import dev.inward.matrix.fact.Model;
import dev.inward.matrix.Identity;
import dev.inward.matrix.Context;

import java.lang.ref.ReferenceQueue;

public class Delegated<S extends Manager<S,P,U,I,X,K,L,?,?,?,?,?>,P extends Intialized<P,I,X>,U extends Functionary<S,P,U,I,X,K,L>,I extends Identity<I,X>,X extends Context<X>,K extends Book<S,P,U,I,X,K,L>,L extends Delegated<S,P,U,I,X,K,L>> extends Model<S,P,U,I,X,K,L> {

    public Delegated(P fact, ReferenceQueue<P> referenceQueue, K bus, U operational) {
        super(fact, referenceQueue, bus, operational);
    }
}
