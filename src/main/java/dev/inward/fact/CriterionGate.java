package dev.inward.fact;

import dev.inward.morph.CreationMorph;
import dev.inward.fact.security.GateSecurity;

public class CriterionGate extends Gate<GateSecurity.RootGate> {
    public CriterionGate(CreationMorph creationMorph) {
        super(creationMorph);
    }
}
