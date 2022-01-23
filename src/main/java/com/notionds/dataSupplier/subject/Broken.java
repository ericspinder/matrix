package com.notionds.dataSupplier.subject;

import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.Id;

import java.lang.reflect.ParameterizedType;
import java.util.UUID;

public class Broken<D extends Datum<?,D,?,?,I>,I extends Id<?,I,?>,EVT extends Broken<D,I,EVT,CALLER>,CALLER> extends Subject<D,I,EVT> {

    private final String caller;
    public Broken(UUID uuid, Matter<D, I, EVT> matter) {
        super(uuid, matter);
        this.caller = ((Class<CALLER>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[3]).getCanonicalName();
    }
    public Broken(UUID uuid, Matter<D,I,EVT> matter, Class<CALLER> callerClass) {
        super(uuid,matter);
        this.caller = callerClass.getCanonicalName();
    }
}
