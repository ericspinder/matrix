package com.notionds.dataSupplier.provider;

import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.fact.Fact;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.operational.Operational;

import java.io.Serializable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

public class Envoy<D extends Datum<D,?,O,I,X,?>,P extends Fact<P,O,I,X,?,A,?>,O extends Operational<P,O,I,X,?>,I extends Id<I,X>,X extends Context<X>,A extends Parent<P,O,I,X,A>,E extends Envoy<D,P,O,I,X,A,E>> extends SoftReference<D> implements Comparable<E>, Serializable {

    private final Parent parent;

    public Envoy(Parent parent, D datum, ReferenceQueue<? super D> referenceQueue) {
        super(datum, referenceQueue);
        this.parent = parent;
    }

    @Override
    public int compareTo(E that) {
        return this.get().compareTo(that.get());
    }
}