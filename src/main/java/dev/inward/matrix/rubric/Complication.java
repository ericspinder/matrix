package dev.inward.matrix.rubric;

import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.*;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.Ambassador;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.operational.Operational;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public abstract class Complication<Y extends Factory<Y,F,O,I,X,B,P,N,NP>,DATUM,D extends Datum<DATUM,D,E>,E extends Envoy<DATUM,D,E,F,I,X,P,N,NP>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P,N,NP>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P,N,NP>,P extends Diplomat<Y,F,O,I,X,B,P,N,NP>,N extends Notion<N,I,X,NP>,NP extends Ambassador<?,N,?,I,X,?, NP,?,?>,COMP extends Complication<Y,DATUM,D,E,F,O,I,X,B,P,N,NP,COMP>> implements Comparable<COMP>, Serializable {


    public Complication(Criteria<DATUM,D,E,F,I,X,P, N,NP,?> criteria, Rubric rubric) {
        criteria;
    }
    public abstract  <CRIT extends Criterion<DATUM,D,E,F,I,X,P,N,NP,CRIT>,PRE extends Predictor<Y,DATUM,D,E,F,O,I,X,B,P,N,NP,CRIT,PRE>> void engage(PRE predictor);
    public final Criteria<DATUM,D,E,F,I,X,P,N,NP,?> getCriteria() {
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
