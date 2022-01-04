package com.notionds.dataSupplier.datum;

import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.datum.context.Context;
import com.notionds.dataSupplier.operational.Operational;

import java.io.Serializable;

public abstract class Datum<D extends Datum<D,O,C,X>,O extends Operational<D,O>,C extends Container<D,O,C,X,?>,X extends Context<D,O,C,X>> implements Comparable<D>, Serializable {

    private final X context;
    private final C container;

    public Datum(X context, C container) {
        this.context = context;
        this.container = container;
    }

    public C getContainer() {
        return this.container;
    }

}
