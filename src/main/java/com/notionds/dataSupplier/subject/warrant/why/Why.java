package com.notionds.dataSupplier.subject.warrant.why;

import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.subject.Matter;
import com.notionds.dataSupplier.subject.Subject;
import com.notionds.dataSupplier.subject.sanction.Sanction;

import java.time.Instant;
import java.util.UUID;

public abstract class Why<I extends Id<I,X>,X extends Context<X>,S extends Sanction<I,X,?>,M extends Why<I,X,S,M>> extends Matter<I,M> {

    private S sanction;

    public Why(UUID uuid, I subjectId, Instant createInstant, Subject subject, S sanction) {
        super(uuid,subjectId,createInstant,subject);
        this.sanction = sanction;
    }

}
