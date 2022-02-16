package com.notionds.dataSupplier.maker;

import com.notionds.dataSupplier.Unspoken;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.house.House;
import com.notionds.dataSupplier.library.Library;
import com.notionds.dataSupplier.subject.Matter;
import com.notionds.dataSupplier.subject.Subject;

import java.time.LocalDateTime;
import java.util.UUID;

public class Engagement<H extends House<H,L>,L extends Library<H,L>,F extends Fingerprint<F>> extends Matter<Id.SuperEgo<H,L>,Engagement<H,L,F>> {

    @Unspoken
    private final F fingerprint;

    public Engagement(UUID uuid, Id.SuperEgo<H,L> id, LocalDateTime createDateTime, Subject subject, F fingerprint) {
        super(uuid, id, createDateTime, subject);
        this.fingerprint = fingerprint;
    }

    public F getFingerprint() {
        return this.fingerprint;
    }
}
