package dev.inward.fact.security;

import dev.inward.morph.CreationMorph;
import dev.inward.fact.Gate;

public abstract class GateSecurity extends Gate<GateSecurity.RootGate> {

    public GateSecurity(CreationMorph creationMorph) {
        super(creationMorph);
    }

    public static class RootGate extends GateSecurity {
        public RootGate(CreationMorph creationMorph) {
            super(creationMorph);
        }
    }
}
