package com.notionds.dataSupplier.setting;

import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.house.House;
import com.notionds.dataSupplier.library.Library;

import java.io.Serializable;

public abstract class Setting<I extends Id<I,X>,X extends Context<X>, S extends Setting<I,X,S>> implements Comparable<S>, Serializable {

    protected final I id;
    public Setting(I id) {
        this.id = id;
    }

    @Override
    public int compareTo(S that) {
        return this.id.compareTo(that.id);
    }

    public final I getId() {
        return this.id;
    }
}
