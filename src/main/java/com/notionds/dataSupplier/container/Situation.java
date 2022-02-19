package com.notionds.dataSupplier.container;

import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.datum.fact.Fact;
import com.notionds.dataSupplier.datum.fact.Support;
import com.notionds.dataSupplier.rubric.Criterion;
import com.notionds.dataSupplier.subject.Breaker;
import com.notionds.dataSupplier.subject.Broken;
import com.notionds.dataSupplier.operational.Operational;
import com.notionds.dataSupplier.provider.Envoy;
import com.sun.jdi.VirtualMachine;
import com.sun.jdi.request.EventRequest;

import java.util.*;
import java.util.concurrent.locks.StampedLock;

public final class Situation<D extends Datum<?,D,C>,C extends Container<D,C>,F extends Fact<F,O,S,I,X,?>,O extends Operational<F,O>,S extends Support<F,O,S,I,X,?>,I extends Id<I,X>,X extends Context<X>> {

    private Phase phase = null;
    private transient StampedLock lock = new StampedLock();
    private transient Map<Phase, PhasedComplication[]> complications = new HashMap<>();

    public List<Broken<D,?,?,?>> phaseChange(Phase entry, D datum, O operational, C container, I id, Criterion.OnPhase<D,O,C,I,?,?,?> criterion) {
        long phaseLock = lock.writeLock();
        List<Broken<D,?,?,?>> issueList = new ArrayList<>();
        try {
            if (phase != null) {
                for (PhasedComplication phasedComplication : complications.get(phase)) {
                    Broken<D,?,?,?> broken =  phasedComplication.disengage(datum, operational, container, id, criterion);
                    if (broken != null) {
                        issueList.add(broken);
                    }
                }
            }
            for (PhasedComplication phasedComplication : complications.get(entry)) {
                Breaker<D,?,?,?,?> breaker = phasedComplication.engage(datum, operational, container, id, criterion);
                if (breaker != null) {
                    issueList.add(breaker);
                }
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
