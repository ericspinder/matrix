package com.notionds.dataSupplier.meta;

import com.notionds.dataSupplier.datum.Datum;

public class Date<D extends Datum<D,D,?,?,?>,M extends Date<D,M>> extends Meta<D,M> {

    private boolean isOldestFirst;
    private boolean indicatesEquality;

    public Date(String label, String description, String i18n) {
        super(label, description, i18n);
    }

}
