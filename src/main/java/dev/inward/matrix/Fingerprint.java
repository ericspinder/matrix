/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.file.addressed.depot.indica.IndiciaKey;

import java.security.PublicKey;
import java.time.Instant;

public abstract class Fingerprint<S extends Scheme<S,L>,L extends Library<S,L>,F extends Fingerprint<S,L,F>> implements Comparable<F> {

    protected final PublicKey publicKey;
    protected final String subjectKeyIdentifier;
    protected final P issuer;

    public Fingerprint(Instant createInstant, IndiciaKey indiciaKey, PublicKey publicKey, String subjectKeyIdentifier, Issuer issuer) {
        super(ego, topicId, createInstant, indiciaKey);
        this.publicKey = publicKey;
        this.subjectKeyIdentifier = subjectKeyIdentifier;
        this.issuer = issuer;
    }
}
