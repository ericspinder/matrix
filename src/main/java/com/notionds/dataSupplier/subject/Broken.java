package com.notionds.dataSupplier.subject;

import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.datum.fact.Fact;

import java.lang.reflect.ParameterizedType;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

public class Broken<D extends Datum<D,FP,?,IP,XP,?,?>,FP extends Fact<FP,?,IP,XP,?,?,?,?,?,?,?>,IP extends Id<IP,XP>,XP extends Context<XP>,M extends Broken<D,FP,IP,XP,M>> extends Matter<IP,M> {

    protected final FP parent;
    protected final D child;
    public Broken(UUID uuid, IP id, Instant createInstant, Subject subject,FP parent,D child) {
        super(uuid, id, createInstant, subject);
        this.parent = parent;
        this.child = child;
    }

}
