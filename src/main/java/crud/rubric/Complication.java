package crud.rubric;

import dev.inward.matrix.datum.Envoy;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.*;
import dev.inward.matrix.datum.fact.notion.concept.*;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.datum.fact.Operational;
import dev.inward.matrix.engine.Criteria;
import dev.inward.matrix.engine.Criterion;

import java.io.Serializable;

public abstract class Complication<Y extends Factory<Y,F,O,I,X,B,P,FAB,C,T,V,M>,DATUM,D extends Datum<DATUM,D,E,F,I,X,P>,E extends Envoy<DATUM,D,E,F,I,X,P>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P>,P extends Model<Y,F,O,I,X,B,P>,FAB extends Fabrication<FAB,C,T,V,M>,C extends Concept<C,M>,T extends Effect<FAB,C,T,V,M>,V extends Volume<FAB,C,T,V,M>,M extends Mortal<FAB,C,T,V,M>,COMP extends Complication<Y,DATUM,D,E,F,O,I,X,B,P,FAB,C,T,V,M,COMP>> implements Comparable<COMP>, Serializable {


    public Complication(Criteria<DATUM,D,E,F,I,X,P> criteria, Rubric rubric) {
        criteria;
    }
    public abstract  <CRIT extends Criterion<DATUM,D,E,F,I,X,P>,PRE extends Predictor<Y,DATUM,D,E,F,O,I,X,B,P,FAB,C,T,V,M,CRIT,PRE>> void engage(PRE predictor);
    public final Criteria<DATUM,D,E,F,I,X,P> getCriteria() {
        return this.criteria;
    }

    public abstract Position engage(E envoy, Position position) throws Roller;

    public enum Position {
        INIT,BEFORE,AFTER,REJECT,GARBAGE,SHUTDOWN
    }

}
//        suppressors("Suppressor",""),
//        confounders("confounders",""),
//        covariates("convariates"),
//        mediators("mediator",""),
//        moderators("",""),
