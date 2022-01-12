package com.notionds.dataSupplier.datum.sanction;

import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.Unspoken;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.house.Ego;
import com.notionds.dataSupplier.maker.Engagement;
import com.notionds.dataSupplier.operational.Operational;

public abstract class Sanction<D extends Sanction<D,O,C,I,E>,O extends Operational<D,O>,C extends Container<D,O,C,I,?>,I extends Engagement<D,O,C,I,?>,E extends Ego<?,?>> extends Datum<D,O,C,I> {

    private final E maker;
    public Sanction(I id, C container, E maker) {
        super(id, container);
        this.maker = maker;
    }
    @Unspoken
    public E getMaker() {
        return this.maker;
    }

}
