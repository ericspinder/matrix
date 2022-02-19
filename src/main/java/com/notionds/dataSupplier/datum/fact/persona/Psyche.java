package com.notionds.dataSupplier.datum.fact.persona;

import com.notionds.dataSupplier.library.Library;

import java.io.Serializable;

public class Psyche<L extends Library<L>,Y extends Psyche<L,Y>> implements Comparable<Y>, Serializable {

    private Directive[] directives;
    @Override
    public int compareTo(Y o) {
        return 0;
    }
}
