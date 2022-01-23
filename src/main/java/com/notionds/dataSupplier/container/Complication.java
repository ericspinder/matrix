package com.notionds.dataSupplier.container;

import com.notionds.dataSupplier.Factory;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.subject.Breaker;
import com.notionds.dataSupplier.subject.Broken;
import com.notionds.dataSupplier.subject.Exceptional;
import com.notionds.dataSupplier.operational.Operational;

import java.io.Serializable;

public abstract class Complication<D extends Datum<?,D,O,C,I>,O extends Operational<D,O>,C extends Container<D,O,C,I>,I extends Id<D,I,?>,I8N, F extends Factory<D,O,?,?,?,?>,C10N extends Complication<D,O,C,I,I8N,F,C10N>> implements Comparable<C10N>, Serializable {

    private final String name;
    private final Phase phase;
    protected final F factory;

    public Complication(String name, Phase phase, F factory) {
        this.name = name;
        this.phase = phase;
        this.factory = factory;
    }

    public abstract <EVT extends Breaker<D,?,?,CALLER,E>,CALLER,E extends Exceptional> Breaker<D,I,?,?,E> engage(D datum, O operational, C container, I id, Class<CALLER> callerClass, I8N indicator);
    public abstract <EVT extends Broken<D,?,?,CALLER>,CALLER> Broken<D,?,?,CALLER> disengage(D datum, O operational, C container, I id, Class<CALLER> callerClass);

    public final String getName() {
        return name;
    }
    public final Phase getPhase() {
        return this.phase;
    }

    @Override
    public int compareTo(C10N that) {
        return this.name.compareTo(that.getName());
    }


}
