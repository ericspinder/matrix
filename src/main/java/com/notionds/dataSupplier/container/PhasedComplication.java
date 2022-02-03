package com.notionds.dataSupplier.container;

import com.notionds.dataSupplier.Factory;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.house.House;
import com.notionds.dataSupplier.library.Library;
import com.notionds.dataSupplier.rubric.Complication;
import com.notionds.dataSupplier.rubric.Criterion;
import com.notionds.dataSupplier.rubric.Predictor;
import com.notionds.dataSupplier.subject.Breaker;
import com.notionds.dataSupplier.subject.Broken;
import com.notionds.dataSupplier.subject.Exceptional;
import com.notionds.dataSupplier.operational.Operational;

public abstract class PhasedComplication<H extends House<H,L>,L extends Library<H,L>,D extends Datum<?,D,O,C,I>, O extends Operational<D,O>,C extends Container<D,O,C,I>,I extends Id<H,L,I,X>,X extends Context<H,L,X>,PRE extends Predictor<H,L,CRIT,PRE>,CRIT extends Criterion.OnPhase<D,O,C,I,X,CRIT,PRE>, C10N extends PhasedComplication<H,L,D,O,C,I,X,PRE,CRIT, C10N>> extends Complication<> {

    private final String name;
    protected final F factory;

    public PhasedComplication(String name) {
        this.name = name;
    }



    public final String getName() {
        return name;
    }
    public final Phase getPhase() {
        return this.phase;
    }

    @Override
    public int compareTo(C10N that) {
        return this.name.compareTo(that.getName());
    }


}
