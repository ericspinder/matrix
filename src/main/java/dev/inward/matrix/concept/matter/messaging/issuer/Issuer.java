package dev.inward.matrix.concept.matter.messaging.issuer;

import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.Identity;
import dev.inward.matrix.Context;


public class Issuer extends Fact<Issuer, Identity.Gate, Context.Path> {

    public Issuer(Identity.Gate id) {
        super(id);
    }
}
