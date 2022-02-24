package com.notionds.dataSupplier.task;

import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.datum.fact.Fact;
import com.notionds.dataSupplier.subject.Matter;
import com.notionds.dataSupplier.subject.Subject;

import java.time.Instant;
import java.util.UUID;

public abstract class Result<F extends Fact<F,?,?,I,X,?>,I extends Id<I,X>,X extends Context<X>,R extends Request<F,I,?,R>,M extends Result<F,I,X,R,M>> extends Matter<I,M> {

    public Result(UUID uuid, I subjectId, Instant createInstant, Subject subject) {
        super(uuid, subjectId, createInstant, subject);
    }
}
