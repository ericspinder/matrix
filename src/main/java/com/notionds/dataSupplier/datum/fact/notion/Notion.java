package com.notionds.dataSupplier.datum.fact.notion;

import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.datum.fact.Fact;


public abstract class Notion<N extends Notion<N,I,X,P>,I extends Id<I,X>,X extends Context<X>,P extends Authority<N,I,X,?,?,?,?>>
        extends Fact<N, Aspirational<N,I,X>,I,X,Omnibus<N,I,X>,P> {
    public Notion(I id, Omnibus<N, I, X> bus) {
        super(id, bus);
    }
}
