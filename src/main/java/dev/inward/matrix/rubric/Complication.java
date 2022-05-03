package dev.inward.matrix.rubric;

import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Bus;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.datum.fact.Progenitor;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.Primogenitor;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.operational.Operational;

import java.io.Serializable;
import java.util.List;

public abstract class Complication<Y extends Factory<Y,F,O,I,X,B,P,NP,PP>,DATUM,D extends Datum<DATUM,D,F,I,X,P,NP,PP,E>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P,NP,PP>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P,NP,PP>,P extends Progenitor<Y,F,O,I,X,B,P,NP,PP>,NP extends Notion<NP,I,X,PP>,PP extends Primogenitor<?,NP,?,I,X,?,PP>,E extends Envoy<Y,DATUM,D,F,O,I,X,B,P,NP,PP,E>,V extends DatumVisitor<Y,DATUM,D,F,O,I,X,B,P,NP,PP,E>,COMP extends Complication<Y,DATUM,D,F,O,I,X,B,P,NP,PP,E,V,COMP>> implements Comparable<COMP>, Serializable {

    protected final V datumVisitor;
    protected final String methodHandle_s;
    protected List<? super Criterion<DATUM,D,F,I,X,P,NP,PP,E,?>> criteria;

    public Complication(V datumVisitor,String methodHandle_s) {
        this.datumVisitor = datumVisitor;
        this.methodHandle_s = methodHandle_s;
    }
    public abstract  <C extends Criterion<DATUM,D,F,I,X,P,NP,PP,E,C>,PRE extends Predictor<Y,DATUM,D,F,O,I,X,B,P,NP,PP,E,C,PRE>> void engage(PRE predictor);
    public final List<? super Criterion<DATUM,D,F,I,X,P,NP,PP,E,?>> getCriteria() {
        return this.criteria;
    }

    public abstract boolean engage(E envoy, Position position);

    public enum Position {
        INIT,BEFORE,AFTER,REJECT,GARBAGE,SHUTDOWN
    }
    public final V getDatumVisitor() {
        return this.datumVisitor;
    }

}
//        suppressors("Suppressor",""),
//        confounders("confounders",""),
//        covariates("convariates"),
//        mediators("mediator",""),
//        moderators("",""),
