package com.notionds.dataSupplier.subject;

import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.Id;

import java.util.UUID;

public class Breaker<D extends Datum<?,D,?,?,I>,I extends Id<D,I,?>,EVT extends Breaker<D,I,EVT,CALLER,E>,CALLER, E extends Exceptional> extends Broken<D,I,EVT,CALLER> {



    public Breaker(UUID uuid, Matter<D, I, EVT> matter, E breaker) {
        super(uuid, matter);

    }
}
