package dev.inward.matrix.fact.matter.sanction;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.Operational;
import dev.inward.matrix.fact.Specification;
import dev.inward.matrix.resources.Supplier;

public class Bureaucracy<I extends Identity<I,X>,X extends Context<X>,IC extends Identity<IC,XC>,XC extends Context<XC>> extends Operational<Governance<I,X,IC,XC>,Regulator<I,X,IC,XC>,Bureaucracy<I,X,IC,XC>,I,X,RedTape<I,X,IC,XC>,Regulated<I,X,IC,XC>,IC,XC> {

    public Bureaucracy(Specification<Regulator<I, X, IC, XC>, I, X> specification, Supplier<Governance<I, X, IC, XC>, Regulator<I, X, IC, XC>, Bureaucracy<I, X, IC, XC>, I, X, RedTape<I, X, IC, XC>, Regulated<I, X, IC, XC>, IC, XC> supplier) {
        super(specification, supplier);
    }
}