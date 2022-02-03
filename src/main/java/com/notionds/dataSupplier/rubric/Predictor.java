package com.notionds.dataSupplier.rubric;

import com.notionds.dataSupplier.house.House;
import com.notionds.dataSupplier.library.Library;

import java.io.Serializable;

public abstract class Predictor<H extends House<H,L>,L extends Library<H,L>,CRIT extends Criterion<?,?,?,?,?,CRIT,PRE>,PRE extends Predictor<H,L,CRIT, PRE>> implements Comparable<PRE>, Serializable {

    private final L library;

    public Predictor(L library) {
        this.library = library;
    }


    public void registerCriterion(CRIT criterion) {
        criterion.engage();
    }

}
