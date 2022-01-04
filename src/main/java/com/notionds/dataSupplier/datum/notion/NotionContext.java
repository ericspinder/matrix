package com.notionds.dataSupplier.datum.notion;

import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.context.Context;
import com.notionds.dataSupplier.operational.Operational;

public abstract class NotionContext<D extends Datum<D,O,C,X>,O extends Operational<D,O>,C extends Container<D,O,C,X,?>,X extends Context<D,O,C,X>> extends Context<D,O,C,X> {

    public NotionContext(X context, C container) {
        super(context, container);
    }
}
