package dev.inward.matrix.datum.fact.matter.sanction;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.matter.messaging.Fingerprint;
import dev.inward.matrix.datum.fact.matter.messaging.issuer.Issuer;
import dev.inward.matrix.datum.fact.matter.Indicia;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.time.Instant;
import java.util.UUID;

public class Aegis extends Fingerprint {

    protected PrivateKey privateKey;
    protected String authorityKeyIdentifier;
    protected AuthorityInfoAccess[] authorityInfoAccesses;
    protected String[] subjectAltNames; // *.example.com

    public Aegis(UUID uuid, Identity.SuperEgo topicId, Instant createInstant, Indicia indicia, PublicKey publicKey, String subjectKeyIdentifier, Issuer issuer) {
        super(uuid, topicId, createInstant, indicia, publicKey, subjectKeyIdentifier, issuer);
    }
}
