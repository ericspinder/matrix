package com.notionds.dataSupplier.meta;


import com.notionds.dataSupplier.Bus;
import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.operational.Operational;

import java.io.Serializable;

public abstract class Create<DATUM extends Comparable<DATUM> & Serializable,O extends Operational<DATUM,O,B,C,U>, B extends Bus<DATUM,O,B,C,U,?,?,?,?>, C extends Container<DATUM,O,B,C,U>,U extends Datum<DATUM,O,B,C,U>> extends Meta<DATUM,O,B,C,U> {

    private boolean isOldestFirst;
    private boolean indicatesEquality;

    public Create(DATUM notion, C container) {
        super(notion, container);
    }

    public Create(DATUM notion, C container, boolean isOldestFirst, boolean indicatesEquality) {
        super(notion, container);
        this.isOldestFirst = isOldestFirst;
        this.indicatesEquality = indicatesEquality;
    }

    @Override
    public int compareTo(U o) {
        return 0;
    }
}
