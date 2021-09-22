package dev.inward.fact.security;

import dev.inward.morph.CreationMorph;
import dev.inward.fact.Fact;

public abstract class Security extends Fact<GateSecurity> {

    public Security(CreationMorph creationMorph) {
        super(creationMorph);
    }
}
