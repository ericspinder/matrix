package com.notionds.dataSupplier.provider;

import dev.inward.matrix.crud.Container;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.operational.Operational;

public abstract class Provider<D extends Datum<D,D,C>,O extends Operational<D,O>,C extends Container<D,O,C,I>,I extends Id<?,?,I,?>, P extends Provider<D,O,C,I,P>> implements Comparable<P> {

    public Provider() {
    }

}
