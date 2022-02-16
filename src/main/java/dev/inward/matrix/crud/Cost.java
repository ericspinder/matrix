package dev.inward.matrix.crud;

import com.notionds.dataSupplier.container.Container;
import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.house.House;
import com.notionds.dataSupplier.library.Library;
import com.notionds.dataSupplier.operational.Operational;
import com.notionds.dataSupplier.rubric.Complication;
import com.notionds.dataSupplier.rubric.Criterion;
import com.notionds.dataSupplier.rubric.Predictor;

public abstract class Cost<H extends House<H,L>,L extends Library<H,L>,D extends Datum<?,D,O,C,I>, O extends Operational<D,O>,C extends Container<D,O,C,I>,I extends Id<H,L,I,X>,X extends Context<H,L,X>,PRE extends Predictor<H,L,CRIT,PRE>,CRIT extends Criterion<D,O,C,I,X,CRIT,PRE>, C10N extends Complication<H,L,D,O,C,I,X,PRE,CRIT, C10N>> extends Complication<H,L,D,O,C,I,x,PRE,CRIT>  {
    public Cost(Predictor predictor, Criterion criterion) {
        super(predictor, criterion);
    }
}
