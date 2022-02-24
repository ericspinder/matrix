package com.notionds.dataSupplier.provider;

import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.datum.fact.Fact;
import com.notionds.dataSupplier.datum.fact.Support;
import com.notionds.dataSupplier.operational.Operational;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

public class Parent<F extends Fact<F,O,S,I,X,?>,O extends Operational<F,O,S,I,X>,S extends Support<F,O,S,I,X,?>,I extends Id<I,X>,X extends Context<X>,P extends Parent<F,O,S,I,X,P>> extends Envoy<F,S,F,O,S,I,X,P> {

    public Parent(F fact, ReferenceQueue<F> referenceQueue, Parent parent) {
        super(fact,referenceQueue,parent);
    }
    public O getOperational() {
        return this.get().getContainer().getBus().getOperational();
    }
    public S getSupport() {
        return this.get().getContainer();
    }
    public I getId() {
        return this.get().getId();
    }
    public X getContext() {
        return this.get().getId().getContext();
    }
}
