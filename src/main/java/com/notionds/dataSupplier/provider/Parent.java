package com.notionds.dataSupplier.provider;

import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.datum.fact.Fact;
import com.notionds.dataSupplier.operational.Operational;

import java.io.Serializable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

public class Parent<F extends Fact<F,O,I,X,?,P>,O extends Operational<F,O,I,X,?,P>,I extends Id<I,X>,X extends Context<X>,P extends Parent<F,O,I,X,P>> extends SoftReference<F> implements Comparable<P>, Serializable {

    public Parent(F fact, ReferenceQueue<F> referenceQueue) {
        super(fact,referenceQueue);
    }

    @Override
    public int compareTo(P o) {
        return 0;
    }
}
