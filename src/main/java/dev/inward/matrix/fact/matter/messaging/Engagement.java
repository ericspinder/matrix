package dev.inward.matrix.fact.matter.messaging;

import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.matter.Indicia;
import dev.inward.matrix.fact.matter.Matter;
import dev.inward.matrix.fact.Context;
import dev.inward.matrix.fact.authoritative.yard.Tree;

import java.lang.ref.SoftReference;
import java.time.Instant;

public class Engagement<E extends Engagement<E,F,P>, F extends Fingerprint,P extends Tree> extends Matter<E, Identity.SuperEgo, Context.Path> {

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
