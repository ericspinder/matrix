package dev.inward.matrix.concept.matter.messaging;

import dev.inward.matrix.*;
import dev.inward.matrix.concept.matter.Indicia;
import dev.inward.matrix.concept.matter.Matter;
import dev.inward.matrix.fact.authoritative.yard.Tree;
import dev.inward.matrix.fact.session.Session;

import java.lang.ref.SoftReference;
import java.time.Instant;

public class Engagement<S extends Scheme<S,L>,L extends Library<S,L>,SESSION extends Session<S,L>, E extends Engagement<S,L,SESSION,E,F,P>, F extends Fingerprint,P extends Tree> extends Matter<E, Identity.Gate, Context.Path> {

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
