package com.notionds.dataSupplier.datum.fact.persona;

import com.notionds.dataSupplier.datum.fact.notion.Aspect;
import com.notionds.dataSupplier.datum.fact.notion.Notion;
import com.notionds.dataSupplier.operational.Operational;

public class Persona<D extends Persona<D,O,C,I>,O extends Operational<D,O>,C extends Aspect<D,O,C,I,?>,I extends SuperEgo<D,I,?,?>> extends Notion<D,O,C,I> {

    public Persona(I id, C container) {
        super(id, container);
    }

    @Override
    public int compareTo(D that) {
        return this.getId().compareTo(that.getId());
    }
}
