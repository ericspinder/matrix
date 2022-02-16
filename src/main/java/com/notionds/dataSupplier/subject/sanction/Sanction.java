package com.notionds.dataSupplier.subject.sanction;

import com.notionds.dataSupplier.Unspoken;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.subject.Subject;
import com.notionds.dataSupplier.subject.Matter;

import java.time.Instant;
import java.util.UUID;

public abstract class Sanction<I extends Id<I,?>,M extends Matter<I,M>> extends Matter<I,M> {

    private final Id.SuperEgo<?> maker;
    public Sanction(UUID uuid, I subjectId, Instant createInstant, Subject subject, Id.SuperEgo maker) {
        super(uuid, subjectId, createInstant, subject);
        this.maker = maker;
    }
    @Unspoken
    public Id.SuperEgo getMaker() {
        return this.maker;
    }

}
