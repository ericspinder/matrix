package com.notionds.dataSupplier.container;

import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.operational.Operational;

import java.io.Serializable;


public abstract class Container<D extends Datum<?,D,O,C,I>,O extends Operational<D,O>,C extends Container<D,O,C,I>,I extends Id<?,?,I,?>> implements Comparable<C>, Serializable {

    private final Situation<D,O,C,I,?,?> situation = new Situation<>();

    public final Situation<D,O,C,I,?,?> getSituation() {
        return this.situation;
    }
}
