package dev.inward.matrix.fact;

import dev.inward.matrix.Pathway;
import dev.inward.matrix.director.library.catalog.Gathering;
import dev.inward.matrix.engine.Engine;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.StampedLock;

public class Factory<PATH extends Comparable<PATH>,P extends Pathway<PATH,P>,ID extends Comparable<ID>,T extends Concept.Tangible<PATH,P,ID,T,C>,C extends Concept<PATH,P,ID,T,C>> extends ClassLoader implements Comparable<Factory<PATH,P,ID,T,C>> {

    private Engine<PATH,P,ID,T,C> engine = null;
    protected final Gathering<PATH,P,ID,T,C,?> gathering;
    protected StampedLock gate = new StampedLock();
    protected final Fact.Resource<PATH,P,ID,T,C> resource;
    protected final Map<> routeMap = new HashMap<>();

    public Factory(Gathering<S,L,P,ID,T,C,?> gathering, Fact.Resource<S,L,P,ID,T,C> resource) {
        this.gathering = gathering;
        this.resource = resource;
    }
    @SuppressWarnings("unchecked")
    public <O extends Operational<S,L,PATH,ID,T,C,?>> void installEngine(O operational) {
        long writeLock = gate.writeLock();
        try {
            boolean isNew = (this.engine == null); // Editions cannot be rolled
            this.engine = new Engine(operational, resource);
            gate.unlockWrite(writeLock);
         }
        finally {
        }
    }

    public Engine<S,L,PATH,ID,T,C,?,?> getEngine() {
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


    @Override
    public int compareTo(Factory<S,L,PATH,ID,T,C> that) {
        return this.uuid.compareTo(that.uuid);
    }
    public Fact.Resource<S,L,PATH,ID,T,C> getResources() {
        return this.resource;
    }

}
