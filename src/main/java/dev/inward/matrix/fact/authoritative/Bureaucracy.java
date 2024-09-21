package dev.inward.matrix.fact.authoritative;

import dev.inward.matrix.fact.Operational;
import dev.inward.matrix.fact.Specification;
import dev.inward.matrix.concept.matter.sanction.RedTape;
import dev.inward.matrix.Context;
import dev.inward.matrix.resources.Supplier;

public class Bureaucracy<VERSION extends Comparable<VERSION>,V extends Identity.Web<VERSION,V,X>,X extends Context<X>,IC extends Identity<IC,XC>,XC extends Context<XC>> extends Operational<Context.Governance<I,X,IC,XC>, Regulator<I,X,IC,XC>,Bureaucracy<I,X,IC,XC>,I,X, RedTape<I,X,IC,XC>, Regulated<I,X,IC,XC>,IC,XC> {

    public Bureaucracy(Specification<Regulator<V, X, IC, XC>, V, X> specification, Supplier<Context.Governance<V, X, IC, XC>, Regulator<, X, IC, XC>, Bureaucracy<I, X, IC, XC>, I, X, RedTape<I, X, IC, XC>, Regulated<I, X, IC, XC>, IC, XC> supplier) {
        super(specification, supplier);
    }
}