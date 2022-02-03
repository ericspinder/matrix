package com.notionds.dataSupplier.subject;

import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.Id;

import java.lang.reflect.ParameterizedType;
import java.time.LocalDateTime;
import java.util.UUID;

public class Broken<D extends Datum<?,D,?,?,I>,I extends Id<?,?,I,?>,MAT extends Broken<D,I,MAT,CALLER>,CALLER> extends Matter<D,I,MAT> {

    private final String caller;
    public Broken(UUID uuid, I id, LocalDateTime createDateTime, Subject subject) {
        super(uuid, id, createDateTime, subject);
        this.caller = ((Class<CALLER>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getCanonicalName();
    }
    public Broken(UUID uuid, I id, LocalDateTime createDateTime, Subject subject, Class<CALLER> callerClass) {
        super(uuid, id, createDateTime, subject);
        this.caller = callerClass.getCanonicalName();
    }

}
