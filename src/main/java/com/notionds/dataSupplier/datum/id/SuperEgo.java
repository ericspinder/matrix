package com.notionds.dataSupplier.datum.id;

import com.notionds.dataSupplier.context.Context;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.notion.fact.Id;

import java.util.UUID;

public abstract class SuperEgo<D extends Datum<D,?,?,I>, I extends SuperEgo<D,I>> extends Id<D,I> {


    public SuperEgo(String name, Context<D> context) {
        super(name, context);
    }
}
