package com.notionds.dataSupplier.datum;

import com.notionds.dataSupplier.container.Container;
import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.operational.Operational;

import java.io.Serializable;

public abstract class Datum<DATUM extends Comparable<D> & Serializable,D extends Datum<DATUM,D,C>,C extends Container<D,C>> implements Comparable<D>, Serializable {

    private final C container;

    public Datum(C container) {
        this.container = container;
    }

    public C getContainer() {
        return this.container;
    }

}
