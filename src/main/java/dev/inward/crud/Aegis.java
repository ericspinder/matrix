/*
 * * Pinder's Matrix © 2025 by Eric S Pinder is licensed under Creative Commons
 *  Attribution-NonCommercial-NoDerivatives 4.0 International. To view a copy of this
 *  license, visit https://creativecommons.org/licenses/by-nc-nd/4.0/
 * /
 */

package dev.inward.crud;

import dev.inward.matrix.file.addressed.AddressedKey;
import dev.inward.matrix.Fingerprint;
import dev.inward.matrix.file.addressed.depot.indica.IndiciaKey;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.time.Instant;
import java.util.UUID;

public class Aegis extends Fingerprint {

    protected PrivateKey privateKey;
    protected String authorityKeyIdentifier;
    protected String[] subjectAltNames; // *.example.com

    public Aegis(UUID uuid, AddressedKey.Gate topicId, Instant createInstant, IndiciaKey indiciaKey, PublicKey publicKey, String subjectKeyIdentifier, Issuer issuer) {
        super(uuid, topicId, createInstant, indiciaKey, publicKey, subjectKeyIdentifier, issuer);
    }
}
