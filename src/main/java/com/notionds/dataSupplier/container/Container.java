package com.notionds.dataSupplier.container;

import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.datum.fact.Fact;
import com.notionds.dataSupplier.datum.fact.Support;
import com.notionds.dataSupplier.operational.Operational;
import com.notionds.dataSupplier.provider.Envoy;
import com.notionds.dataSupplier.rubric.Criterion;
import com.notionds.dataSupplier.subject.Breaker;
import com.notionds.dataSupplier.subject.Broken;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.StampedLock;

public abstract class Container<D extends Datum<?,D,C,F,O,S,I,X>,C extends Container<D,C,F,O,S,I,X>,F extends Fact<F,O,S,I,X,?>,O extends Operational<F,O,S,I,X>,S extends Support<F,O,S,I,X,?>,I extends Id<I,X>,X extends Context<X>> implements Comparable<C>, Serializable {

    private Phase phase = null;
    private Envoy<D,C,F,O,S,I,X> envoy = null;
    private StampedLock lock = new StampedLock();

    public List<Broken<D,F,I,X,?>> phaseChange(Phase entry, D datum) {
        long phaseLock = lock.writeLock();
        try {
            if (envoy != null) {
                List<Broken<D, F, I, X, ?>> issueList = new ArrayList<>();
                if (phase != null) {
                    for (PhasedComplication phasedComplication : envoy.getParent().getContainer().getBus().getOperational().getComplications(datum, Criterion.OnPhase.class)) {
                        Broken<D, F, I, X, ?> broken = phasedComplication.disengage(datum, this);
                        if (broken != null) {
                            issueList.add(broken);
                        }
                    }
                }
                for (PhasedComplication phasedComplication : complications.get(entry)) {
                    Breaker<D, F, I, X, ?, ? super Throwable> breaker = phasedComplication.engage(datum, this);
                    if (breaker != null) {
                        issueList.add(breaker);
                    }
                }
            }
            else (if) {

            }
            this.phase = entry;
        }
        finally {
            lock.unlockWrite(phaseLock);
            return issueList;
        }
    }
    public Phase getPhase() {
        return this.phase;
    }

}
