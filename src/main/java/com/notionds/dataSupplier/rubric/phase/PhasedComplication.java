package com.notionds.dataSupplier.rubric.phase;

import dev.inward.matrix.crud.Container;
import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.datum.fact.Fact;
import dev.inward.matrix.crud.Support;
import com.notionds.dataSupplier.operational.Operational;
import com.notionds.dataSupplier.rubric.Complication;
import com.notionds.dataSupplier.rubric.Corollary;
import com.notionds.dataSupplier.rubric.Criterion;
import com.notionds.dataSupplier.rubric.Predictor;
import com.notionds.dataSupplier.subject.Breaker;
import com.notionds.dataSupplier.subject.Broken;

public class PhasedComplication<D extends Datum<D,D,C>,C extends Container<D,C>,F extends Fact<F,O,S,I,X,?>,O extends Operational<F,O>,S extends Support<F,O,S,I,X,?>,I extends Id<I,X>,X extends Context<X>,T extends Criterion<D,C,F,O,S,F,X,T,PRE>,PRE extends Predictor<D,C,F,O,S,I,X,T,PRE>,Y extends Corollary<I,X,T,Y>> extends Complication<D,C,F,O,S,I,X,T,PRE,Y> {

    public PhasedComplication(PRE predictor,T criterion, Y corollary) {
        super(predictor, criterion, corollary);
    }

    @Override
    public Breaker<D, ?, I, X, ?, ?> engage(D datum, C container, F fact, O operational, S support, I id) {
        return null;
    }

    @Override
    public Broken<D, ?, I, X, ?> disengage(D datum, C container, F fact, O operational, S support, I id) {
        return null;
    }
}