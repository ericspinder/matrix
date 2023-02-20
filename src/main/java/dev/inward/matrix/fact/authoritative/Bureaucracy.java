package dev.inward.matrix.fact.authoritative;

import dev.inward.matrix.fact.Operational;
import dev.inward.matrix.fact.Specification;
import dev.inward.matrix.fact.matter.sanction.RedTape;
import dev.inward.matrix.fact.Context;
import dev.inward.matrix.resources.Supplier;

public class Bureaucracy<VERSION extends Comparable<VERSION>,V extends Identity.WebPage<VERSION,V,X>,X extends Context<X>,IC extends Identity<IC,XC>,XC extends Context<XC>> extends Operational<Governance<I,X,IC,XC>, Regulator<I,X,IC,XC>,Bureaucracy<I,X,IC,XC>,I,X, RedTape<I,X,IC,XC>, Regulated<I,X,IC,XC>,IC,XC> {

    public Bureaucracy(Specification<Regulator<V, X, IC, XC>, V, X> specification, Supplier<Governance<V, X, IC, XC>, Regulator<, X, IC, XC>, Bureaucracy<I, X, IC, XC>, I, X, RedTape<I, X, IC, XC>, Regulated<I, X, IC, XC>, IC, XC> supplier) {
        super(specification, supplier);
    }
}