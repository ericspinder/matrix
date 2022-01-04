package com.notionds.dataSupplier.datum.protocol;

import com.notionds.dataSupplier.Bus;
import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.context.Context;
import com.notionds.dataSupplier.operational.Operational;
import com.notionds.dataSupplier.provider.Situation;

import java.io.Serializable;

public abstract class ProtocolContainer<DATUM extends Comparable<DATUM> & Serializable, D extends Datum<D,O,?,?>,O extends Operational<D,O>,C extends Container<DATUM,O,C,D,B>,X extends Context<>,B extends Bus<DATUM,O,C,D,B,?,?,?>> extends Container<DATUM,D,O,C,X,B> {
    public ProtocolContainer(B bus) {
        super(bus);
    }

    public ProtocolContainer(B bus, Situation currentSituation) {
        super(bus, currentSituation);
    }
}
