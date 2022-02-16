package com.notionds.dataSupplier.meta;

import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.house.House;
import com.notionds.dataSupplier.library.Library;

import java.io.Serializable;

public abstract class Standard<H extends House<H>,L extends Library<L,?>,STAN extends Standard<H,L,STAN>> implements Comparable<STAN>, Serializable {

    private final Id.SuperEgo<H,L> id;
    private final String version;

    protected Standard(Id.SuperEgo<H,L> id, String version) {
        this.id = id;
        this.version = version;
    }

    public Id.SuperEgo<L,> getId() {
        return id;
    }


    public String getVersion() {
        return version;
    }
}
