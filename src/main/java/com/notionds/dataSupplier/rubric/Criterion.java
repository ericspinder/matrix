package com.notionds.dataSupplier.rubric;

import com.notionds.dataSupplier.container.Container;
import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.operational.Operational;

public abstract class Criterion<D extends Datum<?,D,O,C,I>, O extends Operational<D,O>,C extends Container<D,O,C,I>,I extends Id<I,X>,X extends Context<X>, CRIT extends Criterion<D,O,C,I,X,CRIT,PRE>, PRE extends Predictor<CRIT,PRE>> {

    // on method
    // on phase
    // on time
    // on garbage
    // on countdown
    // on shutdown
    public static abstract class OnShutdown<D extends Datum<?,D,O,C,I>, O extends Operational<D,O>,C extends Container<D,O,C,I>,I extends Id<I,X>,X extends Context<X>, CRIT extends Criterion<D,O,C,I,X,CRIT,PRE>, PRE extends Predictor<CRIT,PRE>> extends Criterion<D,O,C,I,X,CRIT,PRE> {

    }
    public static abstract class OnMethod<D extends Datum<?,D,O,C,I>, O extends Operational<D,O>,C extends Container<D,O,C,I>,I extends Id<I,X>,X extends Context<X>, CRIT extends Criterion<D,O,C,I,X,CRIT,PRE>, PRE extends Predictor<CRIT,PRE>> extends Criterion<D,O,C,I,X,CRIT,PRE> {
        public abstract void doMethod();
    }
    public static final class OnPhase<D extends Datum<?,D,O,C,I>, O extends Operational<D,O>,C extends Container<D,O,C,I>,I extends Id<I,X>,X extends Context<X>, CRIT extends Criterion<D,O,C,I,X,CRIT,PRE>, PRE extends Predictor<CRIT,PRE>> extends Criterion<D,O,C,I,X,CRIT,PRE> {


        @Override
        public void enroll(PRE predictor) {

        }
    }
    public static abstract class OnTime<D extends Datum<?,D,O,C,I>, O extends Operational<D,O>,C extends Container<D,O,C,I>,I extends Id<I,X>,X extends Context<X>, CRIT extends Criterion<D,O,C,I,X,CRIT,PRE>, PRE extends Predictor<CRIT,PRE>> extends Criterion<D,O,C,I,X,CRIT,PRE> {

    }


    public Criterion() {

    }
    public abstract void enroll(PRE predictor);


}
