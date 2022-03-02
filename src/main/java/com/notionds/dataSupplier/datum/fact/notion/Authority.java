package com.notionds.dataSupplier.datum.fact.notion;

import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.provider.Parent;

import java.lang.ref.ReferenceQueue;

public class Authority<N extends Notion<N,I,X,NP,IP,XP,A>,I extends Id<I,X>,X extends Context<X>,NP extends Notion<NP,IP,XP,?,?,?,?>,IP extends Id<IP,XP>,XP extends Context<XP>,A extends Authority<N,I,X,NP,IP,XP,A>>
        extends Parent<N,Aspirational<N,I,X>,I,X,NP,Aspirational<NP,IP,XP>,IP,XP,A> {
    public Authority(N fact, ReferenceQueue<N> referenceQueue) {
        super(fact, referenceQueue);
    }
}