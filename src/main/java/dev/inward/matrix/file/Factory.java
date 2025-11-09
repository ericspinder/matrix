/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file;

import dev.inward.matrix.*;
import dev.inward.matrix.catalog.Catalog;
import dev.inward.matrix.control.authority.Authority;
import dev.inward.matrix.control.authority.AuthorityModel;
import dev.inward.matrix.control.authority.AuthorityView;
import dev.inward.matrix.control.library.Library;
import dev.inward.matrix.control.library.LibraryModel;
import dev.inward.matrix.control.library.LibraryView;
import dev.inward.matrix.control.scheme.Scheme;
import dev.inward.matrix.control.scheme.SchemeModel;
import dev.inward.matrix.control.scheme.SchemeView;
import dev.inward.matrix.file.addressed.http.Fact;
import dev.inward.matrix.file.directory.*;
import dev.inward.matrix.item.datum.Datum;

import java.util.concurrent.locks.StampedLock;

public class Factory<S extends Scheme<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,SV extends SchemeView<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,SM extends SchemeModel<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,A extends Authority<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,AV extends AuthorityView<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,AM extends AuthorityModel<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,L extends Library<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,LV extends LibraryView<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,LM extends LibraryModel<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,DF extends Directory<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,DK extends DirectoryKey<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,DV extends DirectoryView<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,DM extends DirectoryModel<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,DR extends DirectoryReference<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,DL extends DirectoryLibrarian<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,DX extends DirectoryContext<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,PATH extends Comparable<PATH>> extends ClassLoader {

    protected final L library;
    protected StampedLock gate = new StampedLock();

    public Factory(L library) {
        super();
        this.library = library;
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

    public Concept<F, K, M> getConcept() {
        return concept;
    }

    public Catalog<F, K, M> getCatalog() {
        return catalog;
    }

    public Gathering<DATUM,V,M,R,B> getGathering() {
        return this.gathering;
    }

    public <DATUM, D extends Datum<DATUM,D,E>,E extends DatumReferenceWeak<DATUM,D,E>> E add(D datum) {
        return null;
    }
    public Fact.AddressedResource<S,L,PATH,ID,T,C> getResources() {
        return this.resource;
    }


}
