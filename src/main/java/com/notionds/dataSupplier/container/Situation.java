package com.notionds.dataSupplier.container;

import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.datum.fact.Fact;
import com.notionds.dataSupplier.house.Ego;
import com.notionds.dataSupplier.subject.Breaker;
import com.notionds.dataSupplier.subject.Broken;
import com.notionds.dataSupplier.operational.Operational;
import com.notionds.dataSupplier.provider.Envoy;

import java.util.*;
import java.util.concurrent.locks.StampedLock;

public final class Situation<D extends Datum<?,D,O,C,I>,O extends Operational<D,O>,C extends Container<D,O,C,I>,I extends Id<?,I,?>,PAR extends Fact<PAR,?,?,PI>,PI extends Ego<?,PI,?>> implements Comparable<Situation<D,O,C,I,PAR,PI>> {

    private Envoy<D,O,C,I,PAR,PI> envoy = null;
    private Phase phase = null;
    private transient StampedLock lock = new StampedLock();
    private transient Map<Phase, PhasedComplication[]> complications = new HashMap<>();

    public <I8N> List<Broken<D,?,?,?>> phaseChange(Phase entry, D datum, O operational, C container, I id, I8N indication) {
        long phaseLock = lock.writeLock();
        List<Broken<D,?,?,?>> issueList = new ArrayList<>();
        try {
            if (phase != null) {
                for (PhasedComplication phasedComplication : complications.get(phase)) {
                    Broken<D,?,?,?> broken =  phasedComplication.disengage(datum, operational, container, id, this.getClass());
                    if (broken != null) {
                        issueList.add(broken);
                    }
                }
            }
            for (PhasedComplication phasedComplication : complications.get(entry)) {
                if (indication instanceof I8N) {
                    Breaker<D,?,?,?,?> breaker = phasedComplication.engage(datum, operational, container, id, this.getClass(), indication);
                    if (breaker != null) {
                        issueList.add(breaker);
                    }
                }
                else {

                }
            }
            this.phase = entry;
        }
        finally {
            lock.unlockWrite(phaseLock);
            return issueList;
        }
    }
    public Envoy<D,O,C,I,PAR,PI> getEnvoy() {
        return this.envoy;
    }
    public void setEnvoy(Envoy<D,O,C,I,PAR,PI> envoy) {
        this.envoy = envoy;
    }

    @Override
    public int compareTo(Situation<D,O,C,I,PAR, PI> that ) {
        if (this.envoy != null && that.envoy != null) {
            return this.envoy.compareTo(that.envoy);
        }
        if (this.equals(that)) return 0;
        if (this.envoy != null) return -1;
        return 1;
    }
}
