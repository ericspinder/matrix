package com.notionds.dataSupplier.subject;

import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.datum.fact.Fact;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

public class Breaker<D extends Datum<?,D,?>,F extends Fact<F,?,?,I,X,?>,I extends Id<I,X>,X extends Context<X>,M extends Breaker<D,F,I,X,M,E>,E extends Throwable> extends Broken<D,F,I,X,M> {

    protected final E breaker;

    public Breaker(UUID uuid, I id, Instant createDateTime, Subject subject,F caller, E breaker) {
        super(uuid, id, createDateTime, subject, caller);
        this.breaker = breaker;
    }

}
