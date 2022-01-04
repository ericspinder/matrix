package com.notionds.dataSupplier.datum.notion;

import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.id.SuperEgo;
import com.notionds.dataSupplier.operational.Operational;

public abstract class Notion<D extends Notion<D,O,C,X,I>,O extends Operational<D,O>,C extends Aspect<D,O,C,X,I,?>,X extends NotionContext<D,O,C,X>,I extends SuperEgo<D,O,C,X,I>> extends Datum<D,O,C,X> {

    protected I id;

    public Notion(I id, X context, C container) {
        super(context,container);
        this.id = id;
    }

    public Class<DATUM> adjust(Class<DATUM> classOfNotion, DATUM notion) throws Issue {
        if (notion instanceof Datum)
        throw new Issue(Issue.Type.Adjustment_Not_Available)
    }

    public U wrapNotion(X container, DATUM notion) {

    }


}
