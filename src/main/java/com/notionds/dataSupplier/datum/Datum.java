package com.notionds.dataSupplier.datum;

import com.notionds.dataSupplier.container.Container;
import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.fact.Fact;
import com.notionds.dataSupplier.datum.fact.Support;
import com.notionds.dataSupplier.operational.Operational;

import java.io.Serializable;

public abstract class Datum<DATUM extends Comparable<D> & Serializable,D extends Datum<DATUM,D,C,F,O,S,I,X>,C extends Container<D,C,F,O,S,I,X>,F extends Fact<F,O,S,I,X,?>,O extends Operational<F,O,S,I,X>,S extends Support<F,O,S,I,X,?>,I extends Id<I,X>,X extends Context<X>> implements Comparable<D>, Serializable {

    private final C container;

    public Datum(C container) {
        this.container = container;
    }

    public C getContainer() {
        return this.container;
    }

}
