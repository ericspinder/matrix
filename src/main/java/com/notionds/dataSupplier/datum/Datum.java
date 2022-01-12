package com.notionds.dataSupplier.datum;

import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.context.Context;
import com.notionds.dataSupplier.datum.notion.fact.Id;
import com.notionds.dataSupplier.operational.Operational;

import java.io.Serializable;

public abstract class Datum<D extends Datum<D,O,C,I>,O extends Operational<D,O>,C extends Container<D,O,C,I,?>,I extends Id<D,I>> implements Comparable<D>, Serializable {

    private final I id;
    private final C container;

    public Datum(I id, C container) {
        this.id = id;
        this.container = container;
    }

    public C getContainer() {
        return this.container;
    }

}
