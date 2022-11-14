package dev.inward.matrix.fact.matter.messaging;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.matter.Matter;
import dev.inward.matrix.fact.matter.Indicia;
import dev.inward.matrix.personality.Persona;

import java.lang.ref.SoftReference;
import java.time.Instant;

public class Engagement<E extends Engagement<E,F,P>, F extends Fingerprint,P extends Persona> extends Matter<E, Identity.SuperEgo,Context.Service> {

    private final F fingerprint;
    protected SoftReference<P> persona;

    public Engagement(Identity.Ego ego, P persona, Instant createDateTime, Indicia indicia, F fingerprint) {
        super(ego,persona.getIdentity(), createDateTime, indicia);
        this.fingerprint = fingerprint;
    }

    public F getFingerprint() {
        return this.fingerprint;
    }
    public P getPersona() {
        return this.persona.get();
    }
}
