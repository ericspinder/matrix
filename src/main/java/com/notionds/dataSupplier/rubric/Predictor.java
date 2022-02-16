package com.notionds.dataSupplier.rubric;

import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.datum.fact.Edition;
import com.notionds.dataSupplier.house.House;
import com.notionds.dataSupplier.library.Library;

import java.io.Serializable;

public abstract class Predictor<CRIT extends Criterion<?,?,?,?,?,CRIT,PRE>,PRE extends Predictor<CRIT, PRE>> implements Comparable<PRE>, Serializable {

//    private final Edition<?> edition;
//
//    public Predictor(L library) {
//        this.library = library;
//    }

    public void registerCriterion(CRIT criterion) {
        criterion.enroll((PRE) this);
    }

}
