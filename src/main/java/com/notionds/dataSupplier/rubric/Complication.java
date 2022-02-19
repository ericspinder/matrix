package com.notionds.dataSupplier.rubric;

import com.notionds.dataSupplier.container.Container;
import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.datum.fact.Fact;
import com.notionds.dataSupplier.datum.fact.Support;
import com.notionds.dataSupplier.operational.Operational;
import com.notionds.dataSupplier.setting.Setting;
import com.notionds.dataSupplier.subject.Breaker;
import com.notionds.dataSupplier.subject.Broken;

public abstract class Complication<I extends Id<I,X>,X extends Context<X>,D extends Datum<?,D,C>,C extends Container<D,C>,F extends Fact<F,O,S,IF,XF,?>,O extends Operational<F,O>,S extends Support<F,O,S,IF,XF,?>,IF extends Id<IF,XF>,XF extends Context<XF>,CRIT extends Criterion<D,C,F,O,S,I,X,CRIT,PRE>,PRE extends Predictor<D,C,F,O,S,I,X,CRIT,PRE>,S extends Complication<I,X,D,C,F,O,S,I,X,PRE,CRIT,S>> extends Setting<I,X,S> {

    protected final PRE predictor;
    protected final CRIT criterion;

    public Complication(I id, PRE predictor, CRIT criterion) {
        super(id);
        this.predictor = predictor
        this.criterion = criterion;
    }
    public abstract Breaker<D,?,I,X,?,?> engage(D datum,C container, F fact, D operational,S support,I id);
    public abstract Broken<D,?,I,X,?> disengage(D datum,C container, F fact, D operational,S support,I id);

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
