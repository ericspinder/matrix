package com.notionds.dataSupplier.subject.warrant.why;

import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.subject.Matter;
import com.notionds.dataSupplier.subject.Subject;
import com.notionds.dataSupplier.subject.sanction.Sanction;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

public abstract class Why<I extends Id<I,?>,M extends Why<I,M,S>,S extends Sanction> extends Matter<I,M>{

    private S sanction;

    public Why(UUID uuid, I subjectId, Instant createInstant, Subject subject, S sanction) {
        super(uuid,subjectId,createInstant,subject);
        this.sanction = sanction;
    }

}
