package com.notionds.dataSupplier.advisor;

import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.Factory;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.context.Context;
import com.notionds.dataSupplier.datum.notion.fact.Id;
import com.notionds.dataSupplier.operational.Operational;

import java.io.Serializable;


public abstract class Advisor<D extends Datum<D,O,C,I>,O extends Operational<D,O>, C extends Container<D,O,C,I,?>,I extends Id<D,I>,A extends Advisor<D,O,C,I,A,F>, F extends Factory<D,O,?,?,?,F>> implements Comparable<A>, Serializable {

    private final F factory;
    public Advisor(F factory) {
        this.factory = factory;
    }

    public void handle(Matter matter, Exception e, D datum) {

    }

    public void handle(Matter matter, D datum) {

    }

}