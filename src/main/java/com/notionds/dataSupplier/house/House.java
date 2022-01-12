package com.notionds.dataSupplier.house;

import com.notionds.dataSupplier.library.Library;

import java.io.Serializable;

public class House<H extends House<H>,L extends Library<H,L>> implements Comparable<H>, Serializable {

    private final L library;
    private final Ego ego;
    public House(Ego ego, L library) {
        this.ego = ego;
        this.library = library;
    }
}
