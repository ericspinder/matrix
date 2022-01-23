package com.notionds.dataSupplier.subject.warrant;

import com.notionds.dataSupplier.container.Container;
import com.notionds.dataSupplier.Promise;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.fact.persona.SuperEgo;
import com.notionds.dataSupplier.operational.Operational;

public abstract class Warrant<D extends Datum<D,O,C,X>,O extends Operational<D,O>,C extends Container<D,O,C,X,?>,X extends Context<D,O,C,X>> extends Promise<D,O,C,X,SuperEgo> {

    private final SuperEgo creator;
    public Warrant(X context, C container, SuperEgo ego) {
        super(context, container, superEgo);
    }
}
