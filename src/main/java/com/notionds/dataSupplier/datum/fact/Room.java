package com.notionds.dataSupplier.datum.fact;

import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.house.House;
import com.notionds.dataSupplier.library.Library;
import com.notionds.dataSupplier.meta.Standard;

import java.time.chrono.Chronology;

public abstract class Room<H extends House<H,L>,L extends Library<H,L>, X extends Context<H,L,X>> {

    private final Door door;
    private final H house;
    private final X context;
    private final Chronology clock;
 `
    public Room(Door door, CRIT criteri  on, X context, H house,Cl) {
        this.door = door;
        this.criterion = criterion;
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
