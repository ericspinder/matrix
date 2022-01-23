package com.notionds.dataSupplier;

import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.house.Ego;
import com.notionds.dataSupplier.operational.Operational;
import com.notionds.dataSupplier.container.Container;

public abstract class Maker<D extends Maker<D,O,C,I,K>, O extends Operational<D,O>,C extends Container<D,O,C,I,?>,I extends Ego<D,I>,K extends Ego<?,?>> extends Datum<D,O,C,I> {

    @Unspoken
    private final K keeper;
    public Maker(I id, C container, K keeper) {
        super(id,container);
        this.keeper = keeper;
    }

    abstract boolean validate(Promise<?,D,?> promise);


}
