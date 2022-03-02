package com.notionds.dataSupplier.rubric;

import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.datum.fact.Bus;
import com.notionds.dataSupplier.datum.fact.Fact;
import com.notionds.dataSupplier.operational.Operational;
import com.notionds.dataSupplier.provider.Parent;
import com.notionds.dataSupplier.provider.Envoy;
import com.notionds.dataSupplier.subject.Breaker;
import com.notionds.dataSupplier.subject.Broken;

public abstract class Complication<D extends Datum<D,E,FP,OP,IP,XP,BP,A>,E extends Envoy<D,FP,OP,IP,XP,E>,FP extends Fact<FP,OP,IP,XP,BP,E,?,?,?,?,?,?>,OP extends Operational<FP,OP,IP,XP>,IP extends Id<IP,XP>,XP extends Context<XP>,BP extends Bus<FP,IP,XP,BP>,A extends Parent,T extends Criterion<D,C,F,O,S,I,X,T,PRE>,PRE extends Predictor<D,C,F,O,S,I,X,T,PRE>, Y extends Corollary<I,X,T,Y>> {

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
