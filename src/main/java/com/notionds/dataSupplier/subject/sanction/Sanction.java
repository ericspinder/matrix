package com.notionds.dataSupplier.subject.sanction;

import com.notionds.dataSupplier.Unspoken;
import com.notionds.dataSupplier.datum.fact.Fact;
import com.notionds.dataSupplier.datum.fact.persona.SuperEgo;
import com.notionds.dataSupplier.house.Ego;
import com.notionds.dataSupplier.house.House;
import com.notionds.dataSupplier.subject.Subject;
import com.notionds.dataSupplier.subject.Matter;

import java.util.UUID;

public abstract class Sanction<D extends Fact<D,?,?,I>,I extends Ego<?,I,?>,H extends House<H,?>,MAT extends Sanction<D,I,H,MAT>> extends Matter<D,I,MAT> {

    private final SuperEgo<H> maker;
    public Sanction(UUID uuid, I id, Subject<D,I,MAT> subject, SuperEgo<H> maker) {
        super(uuid, id, subject);
        this.maker = maker;
    }
    @Unspoken
    public SuperEgo<H> getMaker() {
        return this.maker;
    }

}
