package com.notionds.dataSupplier.subject.sanction;

import com.notionds.dataSupplier.Unspoken;
import com.notionds.dataSupplier.datum.fact.Fact;
import com.notionds.dataSupplier.datum.fact.persona.SuperEgo;
import com.notionds.dataSupplier.house.Ego;
import com.notionds.dataSupplier.house.House;
import com.notionds.dataSupplier.subject.Matter;
import com.notionds.dataSupplier.subject.Subject;

import java.util.UUID;

public abstract class Sanction<D extends Fact<D,?,?,I>,I extends Ego<?,I,?>,H extends House<H,?>,SUB extends Sanction<D,I,H,SUB>> extends Subject<D,I,SUB> {

    private final SuperEgo<H> maker;
    public Sanction(UUID uuid, Matter<D,I,SUB> matter,SuperEgo<H> maker) {
        super(uuid, matter);
        this.maker = maker;
    }
    @Unspoken
    public SuperEgo<H> getMaker() {
        return this.maker;
    }

}
