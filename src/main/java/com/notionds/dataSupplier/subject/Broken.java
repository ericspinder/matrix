package com.notionds.dataSupplier.subject;

import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.datum.fact.Fact;

import java.lang.reflect.ParameterizedType;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

public class Broken<D extends Datum<?,D,?>,F extends Fact<F,?,?,I,X,?>, I extends Id<I,X>,X extends Context<X>,M extends Broken<D,F,I,X,M>> extends Matter<I,M> {

    protected final F caller;
    public Broken(UUID uuid, I id, Instant createInstant, Subject subject,F caller) {
        super(uuid, id, createInstant, subject);
        this.caller = caller;
    }

}
