package dev.inward.fact.session;

import dev.inward.morph.CreationMorph;
import dev.inward.fact.Gate;
import dev.inward.fact.security.GateSecurity;

public class RequestGate<G extends Gate<GateSecurity.RootGate>> extends Gate {

    public RequestGate(CreationMorph creationMorph) {
        super(creationMorph);
    }
}
