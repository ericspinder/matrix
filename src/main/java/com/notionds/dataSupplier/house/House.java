package com.notionds.dataSupplier.house;

import com.notionds.dataSupplier.library.Library;

import java.io.Serializable;

public class House<H extends House<H,L>,L extends Library<H,L>> implements Comparable<H>, Serializable {

    private final L library;
    private final Ego ego;

    public House(Ego ego, L library) {
        this.ego = ego;
        this.library = library;
    }

    @Override
    public int compareTo(H o) {
        return 0;
    }
}
