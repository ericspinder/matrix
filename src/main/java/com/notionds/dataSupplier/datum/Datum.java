package com.notionds.dataSupplier.datum;

import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.container.Phase;
import com.notionds.dataSupplier.operational.Operational;
import com.notionds.dataSupplier.provider.Parent;
import com.notionds.dataSupplier.subject.Broken;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.locks.StampedLock;

public abstract class Datum<D extends Datum<D,O,I,X,P>,O extends Operational<?,O,I,X,?,P>,I extends Id<I,X>,X extends Context<X>,P extends Parent<?,O,I,X,P>> implements Comparable<D>, Serializable {

    private Phase phase = null;
    private A parent = null;
    private StampedLock lock = new StampedLock();

    public List<Broken<D,FP,IP,XP,?>> phaseChange(Phase entry, D datum) {
//        envoy.getParent().getOperational();
//        long phaseLock = lock.writeLock();
//        try {
//            if (envoy != null) {
//                List<Broken<D, F, I, X, ?>> issueList = new ArrayList<>();
//                if (phase != null) {
//                    for (PhasedComplication phasedComplication : envoy.getParent().getContainer().getBus().getOperational().getComplications(datum, Criterion.OnPhase.class)) {
//                        Broken<D, F, I, X, ?> broken = phasedComplication.disengage(datum, this);
//                        if (broken != null) {
//                            issueList.add(broken);
//                        }
//                    }
//                }
//                for (PhasedComplication phasedComplication : complications.get(entry)) {
//                    Breaker<D, F, I, X, ?, ? super Throwable> breaker = phasedComplication.engage(datum, this);
//                    if (breaker != null) {
//                        issueList.add(breaker);
//                    }
//                }
//            }
//            else (if) {
//
//            }
//            this.phase = entry;
//        }
//        finally {
//            lock.unlockWrite(phaseLock);
//            return issueList;
//        }
        return null;
    }
    public Phase getPhase() {
        return this.phase;
    }

}
