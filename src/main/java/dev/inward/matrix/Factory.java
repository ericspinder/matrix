package dev.inward.matrix;

import dev.inward.matrix.Pathway;
import dev.inward.matrix.engine.Engine;
import dev.inward.matrix.http.Fact;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.StampedLock;

public class Factory<PATH extends Comparable<PATH>,ID extends Comparable<ID>,I extends Identity<PATH,ID,I,A,R,F>,A extends Addressed<PATH,ID,I,A,R,F>,R extends Representative<PATH,ID,I,A,R,F>,F extends Addressed.FileAttributes<PATH,ID,I,A,R,F>> extends ClassLoader{

    private Engine<PATH,ID,I,A,R,F> engine = null;
    protected final Gathering<PATH,ID,I,A,R,PR> gathering;
    protected StampedLock gate = new StampedLock();
    protected final Addressed.Resource<PATH,ID,I,A,R,PR> resource;
    protected final Map<> routeMap = new HashMap<>();

    public Factory(Gathering<PATH,,ID,I,A,R,PR> gathering, Addressed.Resource<PATH,ID,I,A,R,PR> resource) {
        super();
        this.gathering = gathering;
        this.resource = resource;
    }
    @SuppressWarnings("unchecked")
    public <O extends Operational<PATH,ID,I,A,R,PR>> void installEngine(O operational) {
        long writeLock = gate.writeLock();
        try {
            boolean isNew = (this.engine == null); // Editions cannot be rolled
            this.engine = new Engine<>(operational, resource);
            gate.unlockWrite(writeLock);
         }
        finally {
        }
    }

    public Engine<PATH,ID,I,A,R,PR> getEngine() {
        long readLock = gate.readLock();
        try {
            return this.engine;
        }
        finally {
            gate.unlockRead(readLock);
        }
    }
    public Gathering<S,L,PATH,ID,T,C,?> getGathering() {
        return this.gathering;
    }

    public <DATUM, D extends Datum<DATUM,D,E>,E extends Envoy<DATUM,D,E>> E add(D datum) {
        return null;
    }
    public Fact.Resource<S,L,PATH,ID,T,C> getResources() {
        return this.resource;
    }


}
