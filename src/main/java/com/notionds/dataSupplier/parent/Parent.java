package com.notionds.dataSupplier.parent;

import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.datum.notion.Aspect;
import com.notionds.dataSupplier.datum.notion.Notion;
import com.notionds.dataSupplier.datum.notion.fact.Id;
import com.notionds.dataSupplier.operational.Operational;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

public class Parent<D extends Notion<D,O,C,I>,O extends Operational<D,O>,C extends Aspect<D,O,C,I,?>,I extends Id<D,I>> extends SoftReference<D> implements Comparable<Parent<D,O,C,I>> {

    private final C aspect;

    public Parent(D referent, ReferenceQueue<D> referenceQueue,C parentAspect) {
        super(referent, referenceQueue);
        this.aspect = parentAspect;
    }

    @Override
    public int compareTo(Parent<D, O, C, I> o) {
        return 0;
    }


}
