package com.notionds.dataSupplier.provider;

import com.notionds.dataSupplier.datum.fact.Bus;
import com.notionds.dataSupplier.container.Container;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.operational.Operational;

import java.io.Serializable;

public class BulkFresh<DATUM extends Comparable<DATUM> & Serializable,O extends Operational<DATUM,O>, B extends Bus<DATUM,O,B,C,D,?,?,?>, C extends Container<DATUM,O,B,C,D>,D extends Datum<D,O,C,?>> extends Provider<DATUM,O,B,C,D> {

    public BulkFresh(O options, B bus) {
        super(bus);
    }

    @Override
    public U getWrappedReady() {
        return null;
    }
}
