package dev.inward.matrix.fact;

import dev.inward.matrix.Scheme;
import dev.inward.matrix.Library;
import dev.inward.matrix.director.library.catalog.Gathering;
import dev.inward.matrix.engine.Engine;
import dev.inward.matrix.Identity;
import dev.inward.matrix.resources.Resources;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.StampedLock;

public class Factory<S extends Scheme<S,L>,L extends Library<S,L>,PATH extends Comparable<PATH>,ID extends Comparable<ID>,T extends Identity.Tangible<S,L,PATH,ID,T,C>,C extends Concept<S,L,PATH,ID,T,C>>  extends ClassLoader implements Comparable<Factory<S,L,PATH,ID,T,C>> {

    private Engine<F,I,ID,X,O,S> engine = null;
    protected final Gathering<S,L,PATH,ID,T,C,?> gathering;
    protected StampedLock gate = new StampedLock();
    protected final Resources<S,L,PATH,ID,T,C> resources;
    protected final Map<> routeMap = new HashMap<>();

    public Factory(Gathering<S,L,PATH,ID,T,C,?> gathering,Resources<S,L,PATH,ID,T,C> resources) {
        this.gathering = gathering;
        this.resources = resources;
    }
    @SuppressWarnings("unchecked")
    public <O extends Operational<S,L,PATH,ID,T,C,?>> void installEngine(O operational) {
        long writeLock = gate.writeLock();
        try {
            boolean isNew = (this.engine == null); // Editions cannot be rolled
            this.engine = new Engine(operational, resources);
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
    public Resources<S,L,PATH,ID,T,C> getResources() {
        return this.resources;
    }

}
