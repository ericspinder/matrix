package com.notionds.dataSupplier.datum.fact;

import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.setting.Setting;

import java.io.Serializable;

public abstract class Track<DATUM extends Comparable<DATUM> & Serializable,I extends Id<I,X>,X extends Context<X>,T extends Track<DATUM,I,X,T>> extends Setting<I,X,T> {

    public Track(I id) {
        super(id);
    }
}
