package dev.inward.matrix.matter.sanction;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.resources.Resources;

public class Governance<I extends Identity<I,X>,X extends Context<X>,IC extends Identity<IC,XC>,XC extends Context<XC>> extends Factory<Governance<I,X,IC,XC>,Regulator<I,X,IC,XC>,Bureaucracy<I,X,IC,XC>,I,X,RedTape<I,X,IC,XC>,Regulated<I,X,IC,XC>,IC,XC> {
    public Governance(Resources<Governance<I, X, IC, XC>, Regulator<I, X, IC, XC>, Bureaucracy<I, X, IC, XC>, I, X, RedTape<I, X, IC, XC>, Regulated<I, X, IC, XC>, IC, XC> resources) {
        super(resources);
    }
}
