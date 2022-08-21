package dev.inward.matrix.matter.sanction;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.maker.Fingerprint;
import dev.inward.matrix.maker.issuer.Issuer;
import dev.inward.matrix.matter.Indicia;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.time.Instant;
import java.util.UUID;

public class Aegis extends Fingerprint {

    protected PrivateKey privateKey;
    protected String authorityKeyIdentifier;
    protected AuthorityAddress[] authorityAddress;
    protected String[] subjectAltNames; // *.example.com
    protected

    public Aegis(UUID uuid, Identity.SuperEgo topicId, Instant createInstant, Indicia indicia, PublicKey publicKey, String subjectKeyIdentifier, Issuer issuer) {
        super(uuid, topicId, createInstant, indicia, publicKey, subjectKeyIdentifier, issuer);
    }
}
