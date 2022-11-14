package dev.inward.matrix.fact.matter.messaging.issuer;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.notion.concept.Context;


public class Issuer extends Fact<Issuer,Identity.SuperEgo,Context.Service> {

    public Issuer(Identity.SuperEgo id) {
        super(id);
    }
}
