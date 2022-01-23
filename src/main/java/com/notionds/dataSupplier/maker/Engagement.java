package com.notionds.dataSupplier.maker;

import com.notionds.dataSupplier.Unspoken;
import com.notionds.dataSupplier.datum.fact.persona.Persona;
import com.notionds.dataSupplier.datum.fact.persona.SuperEgo;
import com.notionds.dataSupplier.subject.Subject;
import com.notionds.dataSupplier.subject.Matter;

import java.util.UUID;

public abstract class Engagement<D extends Persona<D,?,?,I>, I extends SuperEgo<D,I,?,?>,EVT extends Engagement<D,I,EVT,F,ENG>,F extends Fingerprint<F>,ENG extends Engagement<D,I,EVT,F,ENG>> extends Subject<D,I,EVT> {

    @Unspoken
    private final F fingerprint;

    public Engagement(UUID uuid, Matter<D,I,EVT> matter, F fingerprint) {
        super(uuid,matter);
        this.fingerprint = fingerprint;
    }

    public F getFingerprint() {
        return this.fingerprint;
    }
}
