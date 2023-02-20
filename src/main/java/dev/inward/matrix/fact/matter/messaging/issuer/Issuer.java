package dev.inward.matrix.fact.matter.messaging.issuer;

import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.Context;


public class Issuer extends Fact<Issuer,Identity.SuperEgo, Context.Path> {

    public Issuer(Identity.SuperEgo id) {
        super(id);
    }
}
