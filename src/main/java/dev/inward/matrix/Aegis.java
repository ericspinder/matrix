package dev.inward.matrix;

import dev.inward.matrix.log.Indicia;

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
