package com.notionds.dataSupplier.container;

import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.datum.fact.Edition;
import com.notionds.dataSupplier.operational.Operational;

import java.io.Serializable;

public abstract class Container<D extends Datum<?,D,C>,C extends Container<D,C>> implements Comparable<C>, Serializable {

    private final Situation<D,C,?,?> situation = new Situation<>();

    public final Situation<D,O,C,I,?,?> getSituation() {
        return this.situation;
    }

}
