package com.notionds.dataSupplier.datum.notion;

import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.notion.fact.Id;
import com.notionds.dataSupplier.operational.Operational;

public abstract class Notion<D extends Notion<D,O,C,I>,O extends Operational<D,O>,C extends Aspect<D,O,C,I,?>,I extends Id<D,I>> extends Datum<D,O,C,I> {



    public Notion(I id, C container) {
        super(id, container);
    }

//    public Class<DATUM> adjust(Class<DATUM> classOfNotion, DATUM notion) throws Issue {
//        if (notion instanceof Datum)
//        throw new Issue(Issue.Type.Adjustment_Not_Available)
//    }
//
//    public U wrapNotion(X container, DATUM notion) {
//
//    }
//

}
