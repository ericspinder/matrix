package com.notionds.dataSupplier.task;

import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.datum.fact.Fact;
import com.notionds.dataSupplier.subject.warrant.why.Why;
import com.notionds.dataSupplier.subject.sanction.Sanction;

public abstract class Request<D extends Fact<D,?,?,I>,I extends Id.Ego<?,I,?>,S extends Sanction,R extends Request<D,I,S,R>> extends Why<S,R> {

    public Request(S sanction) {
        super(sanction);
    }
}
