package com.notionds.dataSupplier.rubric;

import com.notionds.dataSupplier.container.Container;
import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.datum.fact.Fact;
import com.notionds.dataSupplier.datum.fact.Support;
import com.notionds.dataSupplier.operational.Operational;
import com.notionds.dataSupplier.subject.Breaker;
import com.notionds.dataSupplier.subject.Broken;

public abstract class Complication<D extends Datum<D,D,C>,C extends Container<D,C,F,O,S,I,X>,F extends Fact<F,O,S,I,X,?>,O extends Operational<F,O>,S extends Support<F,O,S,I,X,?>,I extends Id<I,X>,X extends Context<X>,T extends Criterion<D,C,F,O,S,I,X,T,PRE>,PRE extends Predictor<D,C,F,O,S,I,X,T,PRE>, Y extends Corollary<I,X,T,Y>> {

    protected final PRE predictor;
    protected final T criterion;
    protected final Y corollary;

    public Complication(PRE predictor,T criterion,Y corollary) {
        this.corollary = corollary;
        this.predictor = predictor;
        this.criterion = criterion;
    }
    public abstract Breaker<D,?,I,X,?,?> engage(D datum, C container);
    public abstract Broken<D,?,I,X,?> disengage(D datum, C container);

    public final PRE getPredictor() {
        return this.predictor;
    }
    public final T getCriterion() {
        return this.criterion;
    }

}
//        suppressors("Suppressor",""),
//        confounders("confounders",""),
//        covariates("convariates"),
//        mediators("mediator",""),
//        moderators("",""),
