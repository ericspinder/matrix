package dev.inward.matrix.maker;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.maker.issuer.Issuer;
import dev.inward.matrix.matter.Matter;
import dev.inward.matrix.matter.Indicia;
import dev.inward.matrix.path.Path;

import java.security.PublicKey;
import java.time.Instant;
import java.util.UUID;

public class Fingerprint<I extends Identity<I,X>,X extends Path<X>> extends Matter<Fingerprint<I,X>,I,X> {

    protected final PublicKey publicKey;
    protected final String subjectKeyIdentifier;
    protected final Issuer issuer;

    public Fingerprint(UUID uuid, I topicId, Instant createInstant, Indicia indicia, PublicKey publicKey, String subjectKeyIdentifier) {
        super(uuid, topicId, createInstant, indicia);
        this.publicKey = publicKey;
        this.subjectKeyIdentifier = subjectKeyIdentifier;
    }
}
