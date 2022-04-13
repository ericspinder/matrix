package crud;

import dev.inward.matrix.datum.fact.notion.Path;
import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Id;
import dev.inward.matrix.house.House;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.operational.Operational;
import dev.inward.matrix.rubric.Complication;
import dev.inward.matrix.rubric.Criterion;
import dev.inward.matrix.rubric.Predictor;

public abstract class Cost<H extends House<H,L>,L extends Factory<H,L>,D extends Datum<?,D,O,C,I>, O extends Operational<D,O>,C extends Container<D,O,C,I>,I extends Id<H,L,I,X>,X extends Path<H,L,X>,PRE extends Predictor<H,L,CRIT,PRE>,CRIT extends Criterion<D,O,C,I,X,CRIT,PRE>, C10N extends Complication<H,L,D,O,C,I,X,PRE,CRIT, C10N>> extends Complication<H,L,D,O,C,I,x,PRE,CRIT>  {
    public Cost(Predictor predictor, Criterion criterion) {
        super(predictor, criterion);
    }
}
