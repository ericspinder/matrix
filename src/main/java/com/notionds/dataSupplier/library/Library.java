package com.notionds.dataSupplier.library;

import com.notionds.dataSupplier.datum.id.Session;
import com.notionds.dataSupplier.house.House;

import java.io.Serializable;

public class Library<H extends House<H,E,L>, E extends Session<?,E>, L extends Library<H,E,L>> implements Comparable<L>, Serializable {

    public final class InMemoryLibrary <H extends House<H,E,L>, E extends Session<?,E>, L extends Library<H,E,L>> extends Library<H,E,L> {

    }


    @Override
    public int compareTo(L o) {
        return 0;
    }
}
