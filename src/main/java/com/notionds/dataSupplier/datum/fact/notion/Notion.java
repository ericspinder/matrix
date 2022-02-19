package com.notionds.dataSupplier.datum.fact.notion;

import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.datum.fact.Fact;
import com.notionds.dataSupplier.meta.Meta;
import com.notionds.dataSupplier.operational.Operational;


public abstract class Notion<N extends Notion<N,O,I,X>,O extends Operational<N,O>,I extends Id<I,X>,X extends Context<X>> extends Fact<N,O,Aspect<N,O,I,X>,I,X,Omnibus<N,O,I,X>> {

    public Notion(I id,Aspect<N,O,I,X> container) {
        super(id, container);
    }
}
 