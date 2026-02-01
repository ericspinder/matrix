/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.concept.fact.addressed.AddressedKey;
import dev.inward.matrix.item.datum.indica.IndicaKey;
import dev.inward.matrix.item.datum.administrator.Persona;
import dev.inward.matrix.item.datum.log.Log;

import java.time.Instant;

public class Engagement extends Log {

    protected final Persona persona;
    private final F fingerprint;
    protected final SESSION session;

    public Engagement(AddressedKey.Ego ego, P persona, Instant createDateTime, IndicaKey indicaKey, F fingerprint) {
        super(ego,persona.getIdentity(), createDateTime, indicaKey);
        this.fingerprint = fingerprint;
    }

    public F getFingerprint() {
        return this.fingerprint;
    }
    public P getPersona() {
        return this.persona.get();
    }

}
