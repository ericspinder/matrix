package dev.inward.matrix.matter.sanction;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Representative;
import dev.inward.matrix.datum.fact.notion.concept.Context;

public class Regulator<I extends Identity<I,X>,X extends Context<X>,IC extends Identity<IC,XC>,XC extends Context<XC>> extends Fact<Regulator<I,X,IC,XC>,I,X,Regulated<I,X,IC,XC>,IC,XC> {
    public Regulator(I id) {
        super(id);
    }
}
