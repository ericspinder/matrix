package dev.inward.matrix.fact;

import dev.inward.matrix.engine.Engine;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.resources.Resources;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.locks.StampedLock;

public class Factory<F extends Fact<F,I,ID,X>,I extends Identity<I,ID,X>,ID extends Comparable<ID>,X extends Context<F,I,ID,X>> extends ClassLoader implements Serializable {

    protected final Identity.Ego id;
    private Engine<Y,F,I,X,O,B,R,N,NI,NX,A,?,?> engine = null;
    protected StampedLock gate = new StampedLock();
    protected final Resources<F,I,X,R,NI,NX> resources;
    protected final Map<R> routeMap = new HashMap<>();

    public Factory(Resources<F,I,X,R> resources) {
        this.id = new Identity.Ego(UUID.randomUUID(),mortal.getContainerId().getContext());
        this.resources = resources;
        this.getClass().getProtectionDomain();
    }
    @SuppressWarnings("unchecked")
    public <O extends Operational<F,I,X,O,?,?>> void installEngine(O operational) {
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
    public int compareTo(Y that) {
        return this.uuid.compareTo(that.uuid);
    }
    public Resources<F,I,X,R,NI,NX> getResources() {
        return this.resources;
    }

}
