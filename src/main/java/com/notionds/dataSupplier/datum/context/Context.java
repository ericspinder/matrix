package com.notionds.dataSupplier.datum.context;

import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.host.Host;
import com.notionds.dataSupplier.operational.Operational;


public abstract class Context<D extends Datum<D,O,C,X>,O extends Operational<D,O>,C extends Container<D,O,C,X,?>,X extends Context<D,O,C,X>> extends Datum<D,O,C,X> {

    private Host host;
    public Context(X context, C container) {
        super(context, container);
    }
}

