package com.notionds.dataSupplier.datum.fact;

import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.house.House;

public abstract class Room<X extends Context<?,?,X>, H extends House<H,?>> {

    private final H house;
    private final X context;

    public Room(X context, H house) {
        this.context = context;
        this.house = house;
    }

    public H getHouse() {
        return house;
    }

    public X getContext() {
        return context;
    }
}
