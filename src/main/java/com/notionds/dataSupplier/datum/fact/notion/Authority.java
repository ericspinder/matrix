package com.notionds.dataSupplier.datum.fact.notion;

import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.provider.Parent;

import java.lang.ref.ReferenceQueue;

public final class Authority<N extends Notion<N,I,X>,I extends Id<I,X>,X extends Context<X>> extends Parent<N,Asperational<N,I,X>,Aspect<N,I,X>,I,X,Authority<N,I,X>> {
    public Authority(N fact, ReferenceQueue<N> referenceQueue, Parent parent) {
        super(fact, referenceQueue, parent);
    }
}