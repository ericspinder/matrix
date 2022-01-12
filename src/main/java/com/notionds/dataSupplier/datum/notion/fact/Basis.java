package com.notionds.dataSupplier.datum.notion.fact;

import com.notionds.dataSupplier.context.Context;
import com.notionds.dataSupplier.house.House;

import java.util.UUID;

public abstract class Basis<X extends Context<?,?,?,X>, I extends Id<X,I>,H extends House<H,?,?>> extends Id<X,I> {

    private final H house;
    public Basis(X context, H house) {
        this(UUID.randomUUID(),context, house);
    }
    public Basis(UUID uuid, X context, H house) {
        super(uuid,context);
        this.house = house;
    }
}
