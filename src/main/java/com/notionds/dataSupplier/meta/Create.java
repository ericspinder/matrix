package com.notionds.dataSupplier.meta;


import com.notionds.dataSupplier.Bus;
import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.operational.Operational;

import java.io.Serializable;

public abstract class Create<NOTION extends Comparable<NOTION> & Serializable,O extends Operational<NOTION,O,B,C,U>, B extends Bus<NOTION,O,B,C,U,?,?,?,?>, C extends Container<NOTION,O,B,C,U>,U extends Datum<NOTION,O,B,C,U>> extends Meta<NOTION,O,B,C,U> {

    private boolean isOldestFirst;
    private boolean indicatesEquality;

    public Create(NOTION notion, C container) {
        super(notion, container);
    }

    public Create(NOTION notion, C container, boolean isOldestFirst, boolean indicatesEquality) {
        super(notion, container);
        this.isOldestFirst = isOldestFirst;
        this.indicatesEquality = indicatesEquality;
    }

    @Override
    public int compareTo(U o) {
        return 0;
    }
}
