package dev.inward.matrix.matter.sanction;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Bus;
import dev.inward.matrix.datum.fact.notion.concept.Context;

public class RedTape<I extends Identity<I,X>,X extends Context<X>,IC extends Identity<IC,XC>,XC extends Context<XC>> extends Bus<Governance<I,X,IC,XC>,Regulator<I,X,IC,XC>,Bureaucracy<I,X,IC,XC>,I,X,RedTape<I,X,IC,XC>,Regulated<I,X,IC,XC>,IC,XC> {
    public RedTape(Bureaucracy<I, X, IC, XC> operational) {
        super(operational);
    }
}
