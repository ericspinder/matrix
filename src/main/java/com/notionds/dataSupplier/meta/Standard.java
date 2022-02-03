package com.notionds.dataSupplier.meta;

import com.notionds.dataSupplier.datum.fact.persona.SuperEgo;
import com.notionds.dataSupplier.house.House;
import com.notionds.dataSupplier.library.Library;

import java.io.Serializable;

public abstract class Standard<H extends House<H,L>,L extends Library<H,L>,STAN extends Standard<H,L,STAN>> implements Comparable<STAN>, Serializable {

    private final SuperEgo<H,L> id;
    private final String version;

    protected Standard(SuperEgo<H,L> id, String version) {
        this.id = id;
        this.version = version;
    }

    public SuperEgo<H,L> getId() {
        return id;
    }


    public String getVersion() {
        return version;
    }
}
