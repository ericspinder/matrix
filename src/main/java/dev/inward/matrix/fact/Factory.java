package dev.inward.matrix.fact;

import dev.inward.matrix.Context;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.Library;
import dev.inward.matrix.engine.Engine;
import dev.inward.matrix.Identity;
import dev.inward.matrix.fact.authoritative.notion.concept.Protocol;
import dev.inward.matrix.resources.Resources;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.StampedLock;

public class Factory<S extends Scheme<S,L,PATH>,L extends Library<S,L,PATH>,PATH extends Comparable<PATH>,ID extends Comparable<ID>,T extends Identity.Tangible<S,L,PATH,ID,T,C>,C extends Concept<S,L,PATH,ID,T,C>>  extends ClassLoader implements Comparable<Factory<S,L,PATH,ID,T,C>> {

    private Engine<F,I,ID,X,O,S> engine = null;
    protected StampedLock gate = new StampedLock();
    protected final Resources<F,I,ID,X> resources;
    protected final Map<R> routeMap = new HashMap<>();

    public Factory(Resources<F,I,ID,X> resources) {
        this.resources = resources;
    }
    @SuppressWarnings("unchecked")
    public <O extends Operational<F,I,ID,X>> void installEngine(O operational) {
        long writeLock = gate.writeLock();
        try {
            boolean isNew = (this.engine == null); // Editions cannot be rolled
            this.engine = new Engine(operational, resources);
            gate.unlockWrite(writeLock);
         }
        finally {
        }
    }

    public Engine<Y,F,O,I,X,B,R,N,NI,NX,A,U,S> getEngine() {
        long readLock = gate.readLock();
        try {
            return this.engine;
        }
        finally {
            gate.unlockRead(readLock);
        }
    }


    @Override
    public int compareTo(Factory<S,L,PATH,ID,T,C> that) {
        return this.uuid.compareTo(that.uuid);
    }
    public Resources<F,I,X,R,NI,NX> getResources() {
        return this.resources;
    }

}
