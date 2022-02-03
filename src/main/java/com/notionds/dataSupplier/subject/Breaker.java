package com.notionds.dataSupplier.subject;

import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.Id;

import java.time.LocalDateTime;
import java.util.UUID;

public class Breaker<D extends Datum<?,D,?,?,I>,I extends Id<?,?,I,?>,MAT extends Breaker<D,I,MAT,CALLER,E>,CALLER, E extends Exceptional> extends Broken<D,I,MAT,CALLER> {

    private final E breaker;

    public Breaker(UUID uuid, I id, LocalDateTime createDateTime, Subject subject, E breaker) {
        super(uuid, id, createDateTime, subject);
        this.breaker = breaker;

    }
}
