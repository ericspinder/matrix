package com.notionds.dataSupplier.provider;

import com.notionds.dataSupplier.container.Container;
import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.fact.Fact;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.datum.fact.Support;
import com.notionds.dataSupplier.operational.Operational;

import java.io.Serializable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

public class Envoy<D extends Datum<D,D,C,F,O,S,I,X>,C extends Container<D,C,F,O,S,I,X>,F extends Fact<F,O,S,I,X,?>,O extends Operational<F,O,S,I,X>,S extends Support<F,O,S,I,X,?>,I extends Id<I,X>,X extends Context<X>,E extends Envoy<D,C,F,O,S,I,X,E>> extends SoftReference<D> implements Comparable<E>, Serializable {

    protected final Parent<F,O,S,I,X,?> parent;

    public Envoy(D datum, ReferenceQueue<? super D> referenceQueue,Parent<F,O,S,I,X,?> parent) {
        super(datum, referenceQueue);
        this.parent = parent;
    }

    @Override
    public int compareTo(E that) {
        int isZero = this.parent.compareTo(that.parent);
        if (isZero == 0) {
            return this.get().compareTo(that.get());
        }
        return isZero;
    }

    public Parent<F,O,S,I,X,?> getParent() {
        return this.parent;
    }
}
