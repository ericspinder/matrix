package com.notionds.dataSupplier.advisor;

import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.Bus;
import com.notionds.dataSupplier.Factory;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.notion.Notion;
import com.notionds.dataSupplier.options.Options;

import java.io.Serializable;

public abstract class Advisor<DATUM extends Comparable<DATUM> & Serializable,O extends Options<DATUM,O,D>, C extends Container<DATUM,N,O,B,C>,D extends Datum<DATUM,O,C,D,B>,B extends Bus<DATUM,O,C,D,B,?,?,?>,F extends Factory<DATUM,O,B,?>> {

    private final F factory;
    private final B bus;
    public Advisor(F factory, B bus) {
        this.factory = factory;
        this.bus = bus;
    }

    public void handle(Matter matter, Exception e, DATUM notion) {

    }

    public void handle(Matter matter, DATUM notion) {

    }

}