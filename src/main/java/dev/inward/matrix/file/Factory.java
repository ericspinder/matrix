/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file;

import dev.inward.matrix.*;
import dev.inward.matrix.addressed.*;
import dev.inward.matrix.file.addressed.http.Fact;
import dev.inward.matrix.file.directory.*;

import java.util.concurrent.locks.StampedLock;

public class Factory<DF extends Directory<DF,DK,DV,DM,DR,DL,PATH>,DK extends DirectoryKey<DF,DK,DV,DM,DR,DL,PATH>,DV extends DirectoryView<DF,DK,DV,DM,DR,DL,PATH>,DM extends DirectoryModel<DF,DK,DV,DM,DR,DL,PATH>,DR extends DirectoryReference<DF,DK,DV,DM,DR,DL,PATH>,DL extends DirectoryLibrarian<DF,DK,DV,DM,DR,DL,PATH>,PATH extends Comparable<PATH>> extends ClassLoader {

    private Context<DF,DK,DV,DM,DR,DL,PATH> context;
    protected StampedLock gate = new StampedLock();

    public Factory() {
        super();
    }
    @SuppressWarnings("unchecked")
    public <O extends Operational<DATUM,V,M,R,B>> void installEngine(O operational) {
        long writeLock = gate.writeLock();
        boolean isNew = (this.engine == null); // Editions cannot be rolled
        this.engine = new Engine<>(operational,librarian);
        gate.unlockWrite(writeLock);
    }

    public Engine<DATUM,V,M,R,B> getEngine() {
        long readLock = gate.readLock();
        try {
            return this.engine;
        }
        finally {
            gate.unlockRead(readLock);
        }
    }
    public Gathering<DATUM,V,M,R,B> getGathering() {
        return this.gathering;
    }

    public <DATUM, D extends Datum<DATUM,D,E>,E extends DatumReference<DATUM,D,E>> E add(D datum) {
        return null;
    }
    public Fact.AddressedResource<S,L,PATH,ID,T,C> getResources() {
        return this.resource;
    }


}
