package dev.inward.matrix.matter.maker;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.matter.maker.issuer.Issuer;
import dev.inward.matrix.matter.Matter;
import dev.inward.matrix.matter.Indicia;
import java.security.PublicKey;
import java.time.Instant;
import java.util.UUID;

public abstract class Fingerprint extends Matter<Fingerprint,Identity.SuperEgo, Context.Service> {

    protected final PublicKey publicKey;
    protected final String subjectKeyIdentifier;
    protected final Issuer issuer;

    public Fingerprint(UUID uuid, Identity.SuperEgo topicId, Instant createInstant, Indicia indicia, PublicKey publicKey, String subjectKeyIdentifier, Issuer issuer) {
        super(uuid, topicId, createInstant, indicia);
        this.publicKey = publicKey;
        this.subjectKeyIdentifier = subjectKeyIdentifier;
        this.issuer = issuer;
    }
}
