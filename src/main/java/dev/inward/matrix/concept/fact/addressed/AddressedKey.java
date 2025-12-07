/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.fact.addressed;

import dev.inward.matrix.concept.fact.FactKey;
import dev.inward.matrix.concept.fact.directory.*;
import dev.inward.matrix.file.*;
import dev.inward.matrix.file.directory.*;

import java.net.URI;

public abstract class AddressedKey<F extends Addressed<F,ID,K,V,M,R,L,DF,DK,DV,DM,DR,DL,PATH>,ID extends Comparable<ID>,K extends AddressedKey<F,ID,K,V,M,R,L,DF,DK,DV,DM,DR,DL,PATH>,V extends AddressedView<F,ID,K,V,M,R,L,DF,DK,DV,DM,DR,DL,PATH>,M extends AddressedModel<F,ID,K,V,M,R,L,DF,DK,DV,DM,DR,DL,PATH>,R extends AddressedReference<F,ID,K,V,M,R,L,DF,DK,DV,DM,DR,DL,PATH>,L extends AddressedLibrarian<F,ID,K,V,M,R,L,DF,DK,DV,DM,DR,DL,PATH>,DF extends Directory<DF,DK,DV,DM,DR,DL,PATH>,DK extends DirectoryKey<DF,DK,DV,DM,DR,DL,PATH>,DV extends DirectoryView<DF,DK,DV,DM,DR,DL,PATH>,DM extends DirectoryModel<DF,DK,DV,DM,DR,DL,PATH>,DR extends DirectoryReference<DF,DK,DV,DM,DR,DL,PATH>,DL extends DirectoryLibrarian<DF,DK,DV,DM,DR,DL,PATH>,PATH extends Comparable<PATH>> extends FactKey<F,K,V,M,R,L> {

    protected final ID id;
    protected final DK directoryKey;

    protected AddressedKey(URI uri,ID id,DK directoryKey) {
        super(uri);
        this.id = id;
        this.directoryKey = directoryKey;
    }

    public DK getDirectoryKey() {
        return this.directoryKey;
    }

    public ID getId() {
        return id;
    }

    public static abstract class Builder<F extends Addressed<F,ID,K,V,M,R,L,DF,DK,DV,DM,DR,DL,PATH>,ID extends Comparable<ID>,K extends AddressedKey<F,ID,K,V,M,R,L,DF,DK,DV,DM,DR,DL,PATH>,V extends AddressedView<F,ID,K,V,M,R,L,DF,DK,DV,DM,DR,DL,PATH>,M extends AddressedModel<F,ID,K,V,M,R,L,DF,DK,DV,DM,DR,DL,PATH>,R extends AddressedReference<F,ID,K,V,M,R,L,DF,DK,DV,DM,DR,DL,PATH>,L extends AddressedLibrarian<F,ID,K,V,M,R,L,DF,DK,DV,DM,DR,DL,PATH>,DF extends Directory<DF,DK,DV,DM,DR,DL,PATH>,DK extends DirectoryKey<DF,DK,DV,DM,DR,DL,PATH>,DV extends DirectoryView<DF,DK,DV,DM,DR,DL,PATH>,DM extends DirectoryModel<DF,DK,DV,DM,DR,DL,PATH>,DR extends DirectoryReference<DF,DK,DV,DM,DR,DL,PATH>,DL extends DirectoryLibrarian<DF,DK,DV,DM,DR,DL,PATH>,PATH extends Comparable<PATH>> extends FactKey.Builder<F,K,V,M,R,L> {

        protected ID id;
        protected DK directoryKey;

        public Builder<F,ID,K,V,M,R,L,DF,DK,DV,DM,DR,DL,PATH> setId(ID id) {
            this.id = id;
            return this;
        }
        public Builder<F,ID,K,V,M,R,L,DF,DK,DV,DM,DR,DL,PATH> setDirectoryKey(DK directoryKey) {
            this.directoryKey = directoryKey;
            return this;
        }

    }
}
