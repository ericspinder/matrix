package com.notionds.dataSupplier.house;

import com.notionds.dataSupplier.datum.Id;

import java.io.Serializable;

public class House<H extends House<H>> implements Comparable<H>, Serializable {



    public House(Id.Ego ego, L library) {
        this.ego = ego;
        this.library = library;
    }

    @Override
    public int compareTo(H o) {
        return 0;
    }
}
