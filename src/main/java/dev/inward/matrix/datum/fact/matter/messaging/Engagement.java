package dev.inward.matrix.datum.fact.matter.messaging;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.matter.Matter;
import dev.inward.matrix.datum.fact.matter.Indicia;
import dev.inward.matrix.datum.fact.notion.persona.Persona;

import java.lang.ref.SoftReference;
import java.time.Instant;
import java.util.UUID;

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
