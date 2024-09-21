package dev.inward.matrix.concept.matter.messaging;

import dev.inward.matrix.Library;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.concept.matter.Indicia;
import dev.inward.matrix.concept.matter.messaging.issuer.Issuer;

import java.security.PublicKey;
import java.time.Instant;

public abstract class Fingerprint<S extends Scheme<S,L>,L extends Library<S,L>,F extends Fingerprint<S,L,F>> implements Comparable<F> {

    protected final PublicKey publicKey;
    protected final String subjectKeyIdentifier;
    protected final P issuer;

    public Fingerprint(Instant createInstant, Indicia indicia, PublicKey publicKey, String subjectKeyIdentifier, Issuer issuer) {
        super(ego, topicId, createInstant, indicia);
        this.publicKey = publicKey;
        this.subjectKeyIdentifier = subjectKeyIdentifier;
        this.issuer = issuer;
    }
}
