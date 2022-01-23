package com.notionds.dataSupplier.task;

import com.notionds.dataSupplier.datum.fact.Fact;
import com.notionds.dataSupplier.subject.warrant.why.Why;
import com.notionds.dataSupplier.subject.sanction.Sanction;
import com.notionds.dataSupplier.house.Ego;

public abstract class Request<D extends Fact<D,?,?,I>,I extends Ego<D,I>,S extends Sanction,W extends Request<D,I,S,W>> extends Why<S,W> {

    public Request(S sanction) {
        super(sanction);
    }
}
