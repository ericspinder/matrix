package com.notionds.dataSupplier.rubric;

import com.notionds.dataSupplier.NotionClassLoader;
import com.notionds.dataSupplier.container.Container;
import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.house.House;
import com.notionds.dataSupplier.library.Library;
import com.notionds.dataSupplier.operational.Operational;
import com.notionds.dataSupplier.subject.Breaker;
import com.notionds.dataSupplier.subject.Broken;
import com.notionds.dataSupplier.subject.Exceptional;

import java.io.Serializable;

public abstract class Complication<H extends House<H,L>,L extends Library<H,L>,D extends Datum<?,D,O,C,I>, O extends Operational<D,O>,C extends Container<D,O,C,I>,I extends Id<H,L,I,X>,X extends Context<H,L,X>,PRE extends Predictor<H,L,CRIT,PRE>,CRIT extends Criterion<D,O,C,I,X,CRIT,PRE>, C10N extends Complication<H,L,D,O,C,I,X,PRE,CRIT, C10N>> implements Comparable<C10N>, Serializable {

    private final PRE predictor;
    private final CRIT criterion;

    public Complication(PRE predictor, CRIT criterion) {
        this.predictor = predictor;
        this.criterion = criterion;
    }
    public abstract <MAT extends Breaker<D,?,?,CALLER,?>,CALLER> Breaker<D,I,?,?,?> classLoader(NotionClassLoader<D,>)
    public abstract <MAT extends Breaker<D,?,?,CALLER,?>,CALLER> Breaker<D,I,?,?,?> engage(D datum, O operational, C container, I id, Class<CALLER> callerClass, CRIT criterion);
    public abstract <MAT extends Broken<D,?,?,CALLER>,CALLER> Broken<D,?,?,CALLER> disengage(D datum, O operational, C container, I id, Class<CALLER> callerClass);

    @Override
    public int compareTo(Complication o) {
        return 0;
    }
    public final PRE getPredictor() {
        return this.predictor;
    }
    public final CRIT getCriterion() {
        return this.criterion;
    }
}
//        suppressors("Suppressor",""),
//        confounders("confounders",""),
//        covariates("convariates"),
//        mediators("mediator",""),
//        moderators("",""),
