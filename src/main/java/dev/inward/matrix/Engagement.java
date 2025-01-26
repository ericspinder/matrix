package dev.inward.matrix;

import dev.inward.matrix.fact.authoritative.yard.Tree;
import dev.inward.matrix.log.Indicia;
import dev.inward.matrix.log.Matter;

import java.time.Instant;

public class Engagement<E extends Engagement<E,F,P>, F extends Fingerprint,P extends Tree> extends Matter<E,> {

    protected final Dogma.Persona persona;
    private final F fingerprint;
    protected final SESSION session;

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
