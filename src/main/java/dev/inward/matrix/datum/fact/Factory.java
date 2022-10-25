package dev.inward.matrix.datum.fact;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Agent;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.concept.*;
import dev.inward.matrix.engine.Engine;
import dev.inward.matrix.resources.Resources;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.locks.StampedLock;

public abstract class Factory<Y extends Factory<Y,F,O,I,X,B,R,N,NI,NX,A,S>,F extends Fact<F,I,X,R,NI,NX>,O extends Operational<F,O,I,X,B,R,N,NI,NX,A>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<F,I,X,B,R,N,NI,NX,A,?>,R extends Representative<F,I,X,R,NI,NX>,N extends Notion<N,NI,NX,A>,NI extends Identity<NI,NX>,NX extends Context<NX>,A extends Agent<N,NI,NX,A>,S extends Resources<F,I,X,R,NI,NX>> extends ClassLoader implements Comparable<Y>, Serializable {

    protected final Identity.Ego id;
    private Engine<Y,F,O,I,X,B,R,N,NI,NX,A,S> engine = null;
    protected StampedLock gate = new StampedLock();
    protected final Resources<F,I,X,R,NI,NX> resources;
    protected final Map<B,R> routeMap = new HashMap<>();

    public Factory(Mortal<?,?> mortal, Resources<F,I,X,R,NI,NX> resources) {
        this.id = new Identity.Ego(UUID.randomUUID(),mortal.getContainerId().getContext());
        this.resources = resources;
    }
    @SuppressWarnings("unchecked")
    public void installEngine(O operational) {
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
