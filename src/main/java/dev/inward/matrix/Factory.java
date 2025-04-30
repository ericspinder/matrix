/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.addressed.*;
import dev.inward.matrix.file.addressed.http.Fact;

import java.util.concurrent.locks.StampedLock;

public class Factory<DATUM,V extends View<DATUM,V,M,R,B>,M extends Model<DATUM>,R extends Reference<DATUM,V,M,R,B>,B extends Librarian<DATUM,V,M,R,B>> extends ClassLoader {

    private Engine<DATUM,V,M,R,B> engine = null;
    protected StampedLock gate = new StampedLock();
    protected final B librarian;

    public Factory() {
        super();
        this.gathering = gathering;
        this.resource = resource;
    }
    @SuppressWarnings("unchecked")
    public <O extends Operational<PATH,ID,I,A,R,PR>> void installEngine(O operational) {
        long writeLock = gate.writeLock();
        boolean isNew = (this.engine == null); // Editions cannot be rolled
        this.engine = new Engine<>(operational, resource);
        gate.unlockWrite(writeLock);
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

    public <DATUM, D extends Datum<DATUM,D,E>,E extends DatumReference<DATUM,D,E>> E add(D datum) {
        return null;
    }
    public Fact.AddressedResource<S,L,PATH,ID,T,C> getResources() {
        return this.resource;
    }


}
