package dev.inward.matrix.concept.matter.sanction;

import dev.inward.matrix.Identity;
import dev.inward.matrix.concept.matter.Indicia;
import dev.inward.matrix.concept.matter.messaging.Fingerprint;
import dev.inward.matrix.concept.matter.messaging.issuer.Issuer;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.time.Instant;
import java.util.UUID;

public class Aegis extends Fingerprint {

    protected PrivateKey privateKey;
    protected String authorityKeyIdentifier;
    protected String[] subjectAltNames; // *.example.com

    public Aegis(UUID uuid, Identity.Gate topicId, Instant createInstant, Indicia indicia, PublicKey publicKey, String subjectKeyIdentifier, Issuer issuer) {
        super(uuid, topicId, createInstant, indicia, publicKey, subjectKeyIdentifier, issuer);
    }
}
