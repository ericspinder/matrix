package com.notionds.dataSupplier.task;

import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.datum.fact.Fact;
import com.notionds.dataSupplier.subject.Matter;
import com.notionds.dataSupplier.subject.Subject;

import java.time.Instant;
import java.util.UUID;

public abstract class Result<I extends Id<?,I,?>,M extends Matter<I,M>,F extends Fact<F,?,?,?>,R extends Request<F,?,?,R>> extends Matter<I,M> {


    public Result(UUID uuid, I subjectId, Instant createInstant, Subject subject) {
        super(uuid, subjectId, createInstant, subject);
    }
}
