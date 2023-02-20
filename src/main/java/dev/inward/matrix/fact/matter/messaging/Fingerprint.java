package dev.inward.matrix.fact.matter.messaging;

import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.matter.Indicia;
import dev.inward.matrix.fact.matter.Matter;
import dev.inward.matrix.fact.matter.messaging.issuer.Issuer;
import dev.inward.matrix.fact.Context;
import dev.inward.matrix.fact.authoritative.yard.Tree;

import java.security.PublicKey;
import java.time.Instant;

public class Fingerprint<P extends Tree> extends Matter<Fingerprint,Identity.SuperEgo, Context.Path> {

    protected final PublicKey publicKey;
    protected final String subjectKeyIdentifier;
    protected final P issuer;

    public Fingerprint(Identity.Ego ego, Identity.SuperEgo topicId, Instant createInstant, Indicia indicia, PublicKey publicKey, String subjectKeyIdentifier, Issuer issuer) {
        super(ego, topicId, createInstant, indicia);
        this.publicKey = publicKey;
        this.subjectKeyIdentifier = subjectKeyIdentifier;
        this.issuer = issuer;
    }
}
