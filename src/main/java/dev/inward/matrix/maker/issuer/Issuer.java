package dev.inward.matrix.maker.issuer;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.notion.concept.Context;


public class Issuer extends Fact<Issuer,Identity.SuperEgo,Context.Service,Imprint,Identity.SuperEgo,Context.Service> {

    public Issuer(Identity.SuperEgo id) {
        super(id);
    }
}
