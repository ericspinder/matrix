package dev.inward.matrix.fact.datum;

import dev.inward.matrix.fact.Bus;
import dev.inward.matrix.fact.Criterion;
import dev.inward.matrix.fact.Predictable;
import dev.inward.matrix.phenomenon.producer.ExecutionExceptionly;

import java.io.Serializable;
import java.lang.invoke.*;

public abstract class Complication<DATUM,E extends Envoy<DATUM>,CRIT extends Criterion<CRIT>,PRE extends Predictable<DATUM,E,CRIT,PRE>,COMP extends Complication<DATUM,E,CRIT,PRE,COMP>> implements Runnable, Serializable {

    protected final CRIT criterion;
    protected final PRE predictable;
    protected final CallSite callSite;


    public Complication(CRIT criterion, PRE predictable) {
        this.criterion = criterion;
        this.predictable = predictable;
        this.callSite = predictable.registerCriterion(criterion);
    }
    public void engage(Bus bus, E envoy) throws ExecutionExceptionly {
        MethodHandle methodHandle = callSite.getTarget();
        predictable.complete(this.criterion, envoy, methodHandle);

    }
    @Override
    public int compareTo(COMP that) {
        int isZero = this.criterion.getOrder() - that.criterion.getOrder();
        if (isZero == 0) {
            isZero = this.predictable.compareTo(that.predictable);
            if (isZero == 0) {
                isZero = this.criterion
            }
        }
    }
}
//        suppressors("Suppressor",""),
//        confounders("confounders",""),
//        covariates("convariates"),
//        mediators("mediator",""),
//        moderators("",""),
