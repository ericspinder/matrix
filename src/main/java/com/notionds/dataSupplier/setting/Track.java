package com.notionds.dataSupplier.setting;


import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.house.House;
import com.notionds.dataSupplier.library.Library;
import com.notionds.dataSupplier.subject.Broken;

import java.util.concurrent.locks.StampedLock;

public abstract class Track<L extends Library<L>,D extends Datum<?,D,?,?,DI>,DI extends Id<DI,X>,I extends Id<I,X>,X extends Context<X>, S extends Track<L,D,DI,I,X,S>> extends Setting<L,I,X,S> {

    public Track(I id) {
        super(id);
    }
    public abstract <D extends Datum<?,D,?,?,?>> Broken<D,?,?,?> apply(D datum);
}
