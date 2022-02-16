package com.notionds.dataSupplier.rubric;

import com.notionds.dataSupplier.container.Container;
import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.operational.Operational;
import com.notionds.dataSupplier.setting.Setting;
import com.notionds.dataSupplier.subject.Breaker;
import com.notionds.dataSupplier.subject.Broken;

public abstract class Complication<I extends Id<I,X>,X extends Context<X>,D extends Datum<?,D,OD,CD,ID>,OD extends Operational<D,OD>,CD extends Container<D,OD,CD,ID>,ID extends Id<ID,XD>,XD extends Context<XD>,PRE extends Predictor<CRIT,PRE>,CRIT extends Criterion<D,OD,CD,ID,XD,CRIT,PRE>,S extends Complication<I,X,D,OD,CD,ID,XD,PRE,CRIT,S>> extends Setting<I,X,S> {

    protected final PRE predictor;
    protected final CRIT criterion;

    public Complication(I id, PRE predictor, CRIT criterion) {
        super(id);
        this.predictor = predictor;
        this.criterion = criterion;
    }
    public abstract Breaker<D,ID,?,?,?> engage(D datum,OD operational,CD container,ID id, CRIT criterion);
    public abstract <MAT extends Broken<D,?,?,CALLER>,CALLER> Broken<D,?,?,CALLER> disengage(D datum,OD operational,CD container,ID id,CRIT criterion);

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
