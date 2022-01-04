package com.notionds.dataSupplier.datum.notion.why;

import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.context.Context;
import com.notionds.dataSupplier.datum.notion.warrant.Warrant;
import com.notionds.dataSupplier.operational.Operational;

public abstract class Why<D extends Datum<D,O,C,X>,O extends Operational<D,O>,C extends Container<D,O,C,?,?>,X extends Context<D,O,C,X>> extends Datum<D,O,C,X> {

    private Warrant warrant;
    public Why(X context, C container) {
        super(context, container);
    }

}
