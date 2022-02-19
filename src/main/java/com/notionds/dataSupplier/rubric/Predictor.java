package com.notionds.dataSupplier.rubric;

import com.notionds.dataSupplier.container.Container;
import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.datum.fact.Fact;
import com.notionds.dataSupplier.datum.fact.Support;
import com.notionds.dataSupplier.operational.Operational;

import static com.notionds.dataSupplier.rubric.Criterion.*;

public abstract class Predictor<D extends Datum<?,D,C>,C extends Container<D,C>,F extends Fact<F,O,S,I,X,?>,O extends Operational<F,O>,S extends Support<F,O,S,I,X,?>,I extends Id<I,X>,X extends Context<X>, CRIT extends Criterion<D,C,F,O,S,I,X,CRIT,PRE>, PRE extends Predictor<D,C,F,O,S,I,X,CRIT,PRE>> {

    public void registerCriterion(CRIT criterion) {
        criterion.enroll((PRE) this);
    }

    public final static class Phase<D extends Datum<?,D,C>,C extends Container<D,C>,F extends Fact<F,O,S,I,X,?>,O extends Operational<F,O>,S extends Support<F,O,S,I,X,?>,I extends Id<I,X>,X extends Context<X>> extends Predictor<D,C,F,O,S,I,X,OnPhase<D,C,F,O,S,I,X>,Phase<D,C,F,O,S,I,X>> {}
    public final static class Shutdown<D extends Datum<?,D,C>,C extends Container<D,C>,F extends Fact<F,O,S,I,X,?>,O extends Operational<F,O>,S extends Support<F,O,S,I,X,?>,I extends Id<I,X>,X extends Context<X>> extends Predictor<D,C,F,O,S,I,X,OnShutdown<D,C,F,O,S,I,X>,Shutdown<D,C,F,O,S,I,X>> { }
    public final static class Method<D extends Datum<?,D,C>,C extends Container<D,C>,F extends Fact<F,O,S,I,X,?>,O extends Operational<F,O>,S extends Support<F,O,S,I,X,?>,I extends Id<I,X>,X extends Context<X>> extends Predictor<D,C,F,O,S,I,X,OnMethod<D,C,F,O,S,I,X>,Method<D,C,F,O,S,I,X>>{}
    public final static class Garbage<D extends Datum<?,D,C>,C extends Container<D,C>,F extends Fact<F,O,S,I,X,?>,O extends Operational<F,O>,S extends Support<F,O,S,I,X,?>,I extends Id<I,X>,X extends Context<X>> extends Predictor<D,C,F,O,S,I,X,OnGarbage<D,C,F,O,S,I,X>,Garbage<D,C,F,O,S,I,X>>{}
    public final static class Time<D extends Datum<?,D,C>,C extends Container<D,C>,F extends Fact<F,O,S,I,X,?>,O extends Operational<F,O>,S extends Support<F,O,S,I,X,?>,I extends Id<I,X>,X extends Context<X>> extends Predictor<D,C,F,O,S,I,X,OnTime<D,C,F,O,S,I,X>,Time<D,C,F,O,S,I,X>>{}
    public final static class Countdown<D extends Datum<?,D,C>,C extends Container<D,C>,F extends Fact<F,O,S,I,X,?>,O extends Operational<F,O>,S extends Support<F,O,S,I,X,?>,I extends Id<I,X>,X extends Context<X>> extends Predictor<D,C,F,O,S,I,X,OnCountdown<D,C,F,O,S,I,X>,Countdown<D,C,F,O,S,I,X>>{}
}
