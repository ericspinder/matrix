package dev.inward.matrix.fact.intialized;

import dev.inward.matrix.fact.Operational;
import dev.inward.matrix.fact.Specification;
import dev.inward.matrix.Context;
import dev.inward.matrix.resources.Supplier;

import java.security.ProtectionDomain;

public class Functionary<S extends Manager<S,P,U,I,X,K,L,?,?,?,?,?>,P extends Intialized<P,I,X>,U extends Functionary<S,P,U,I,X,K,L>,I extends Identity<I,X>,X extends Context<X>,K extends Book<S,P,U,I,X,K,L>,L extends Delegated<S,P,U,I,X,K,L>> extends Operational<S,P,U,I,X,K,L> {

    public Functionary(Specification specification, Supplier<S, P, U, I, X, K, L, ?, ?, ?, ?, ?> supplier, ProtectionDomain protectionDomain) {
        super(specification, supplier, protectionDomain);
    }
}
