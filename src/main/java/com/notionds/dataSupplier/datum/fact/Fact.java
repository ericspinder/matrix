package com.notionds.dataSupplier.datum.fact;

import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.operational.Operational;

public abstract class Fact<F extends Fact<F,O,S,I,X,B>,O extends Operational<F,O>,S extends Support<F,O,S,I,X,B>,I extends Id<I,X>,X extends Context<X>,B extends Bus<F,O,I,X,B>> extends Datum<F,F,S> implements Id.Addressable<I,X> {

    private final I id;

    public Fact(I id, S support) {
        super(support);
        this.id = id;
    }

    @Override
    public I getId() {
        return this.id;
    }

    @Override
    public int compareTo(F that) {
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
