package dev.inward.matrix.fact.datum;

import dev.inward.matrix.fact.*;
import dev.inward.matrix.phenomenon.producer.WorkException;

import java.io.Serializable;
import java.lang.invoke.CallSite;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.invoke.MutableCallSite;

public abstract class Complication<DATUM,V extends Envoy<DATUM,V>,CRIT extends Criterion<DATUM>,PRE extends Predicted<DATUM,CRIT,PRE>,COMP extends Complication<DATUM,V,CRIT,PRE,COMP>> implements Comparable<COMP>, Serializable {

    protected final CRIT criterion;
    protected final PRE predicted;

    public Complication(CRIT criterion, PRE predicted) {
        this.criterion = criterion;
        this.predicted = predicted;
    }
    public void engage(V envoy) throws WorkException {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        lookup.bind(envoy.get(),criterion.getName(), MethodType.methodType(criterion));
        CallSite callSite = new MutableCallSite()
    }
}
//        suppressors("Suppressor",""),
//        confounders("confounders",""),
//        covariates("convariates"),
//        mediators("mediator",""),
//        moderators("",""),
