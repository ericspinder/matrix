package com.notionds.dataSupplier.datum.fact;

import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.house.Ego;
import com.notionds.dataSupplier.operational.Operational;

public abstract class Fact<D extends Fact<D,O,C,I>,O extends Operational<D,O>,C extends Support<D,O,C,I,?>,I extends Ego<?,I,?>> extends Datum<D,D,O,C,I> {

    private final I id;

    public Fact(I id, C container) {
        super(container);
        this.id = id;
    }

    public I getId() {
        return this.id;
    }

    @Override
    public int compareTo(D that) {
        return this.id.compareTo(that.getId());
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
