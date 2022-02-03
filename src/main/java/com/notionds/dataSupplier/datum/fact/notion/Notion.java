package com.notionds.dataSupplier.datum.fact.notion;

import com.notionds.dataSupplier.datum.fact.Fact;
import com.notionds.dataSupplier.house.Ego;
import com.notionds.dataSupplier.operational.Operational;


public abstract class Notion<D extends Notion<D,O,C,I>,O extends Operational<D,O>,C extends Aspect<D,O,C,I,?>,I extends Ego<?,?,I,?>> extends Fact<D,O,C,I> {


    public Notion(I id, C container) {
        super(id, container);
    }
}
