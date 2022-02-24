package com.notionds.dataSupplier.datum.fact.notion;

import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.datum.fact.Fact;
import com.notionds.dataSupplier.datum.fact.Support;


public abstract class Notion<N extends Notion<N,I,X>,I extends Id<I,X>,X extends Context<X>> extends Fact<N,Aspect<N,I,X>,I,X,Omnibus<N,I,X>> {

    public Notion(Id id, Support support) {
        super(id, support);
    }
}
 