package dev.inward.matrix.fact;

import dev.inward.matrix.*;
import dev.inward.matrix.Pathway;
import dev.inward.matrix.director.library.catalog.Gathering;
import dev.inward.matrix.engine.Engine;
import dev.inward.matrix.engine.Variant;
import dev.inward.matrix.personality.Psyche;

import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.StampedLock;

public class Factory<PATH extends Comparable<PATH>,ID extends Comparable<ID>,I extends Identity<PATH,ID,I,A,R,PR>,A extends Addressed<PATH,ID,I,A,R,PR>,R extends Representitive<PATH,ID,I,A,R,PR>,PR extends Representitive<PATH,?,?,?,PR,?>> extends URLClassLoader implements Comparable<Factory<PATH,ID,I,A,R,PR>> {

    private Engine<PATH,ID,I,A,R,PR> engine = null;
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
    public <O extends Operational<PATH,ID,I,A,R>> void installEngine(O operational) {
        long writeLock = gate.writeLock();
        try {
            boolean isNew = (this.engine == null); // Editions cannot be rolled
            this.engine = new Engine<>(operational, resource);
            gate.unlockWrite(writeLock);
         }
        finally {
        }
    }

    public Engine<PATH,X,ID,I,C,R> getEngine() {
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
    @Override
    public int compareTo(Factory<PATH,X,ID,I,C,R> that) {
        return this.uuid.compareTo(that.uuid);
    }
    public Fact.Resource<S,L,PATH,ID,T,C> getResources() {
        return this.resource;
    }


}
