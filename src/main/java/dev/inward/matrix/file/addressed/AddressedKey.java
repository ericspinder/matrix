/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed;

import dev.inward.matrix.control.catalog.*;
import dev.inward.matrix.control.library.*;
import dev.inward.matrix.control.scheme.Scheme;
import dev.inward.matrix.file.*;
import dev.inward.matrix.file.directory.*;

import java.net.URI;
import java.net.URISyntaxException;

public abstract class AddressedKey<F extends Addressed<F,ID,K,V,M,R,L,DF,DK,DV,DM,DR,DL,PATH>,ID extends Comparable<ID>,K extends AddressedKey<F,ID,K,V,M,R,L,DF,DK,DV,DM,DR,DL,PATH>,V extends AddressedView<F,ID,K,V,M,R,L,DF,DK,DV,DM,DR,DL,PATH>,M extends AddressedModel<F,ID,K,V,M,R,L,DF,DK,DV,DM,DR,DL,PATH>,R extends AddressedReference<F,ID,K,V,M,R,L,DF,DK,DV,DM,DR,DL,PATH>,L extends AddressedLibrarian<F,ID,K,V,M,R,L,DF,DK,DV,DM,DR,DL,PATH>,DF extends Directory<DF,DK,DV,DM,DR,DL,PATH>,DK extends DirectoryKey<DF,DK,DV,DM,DR,DL,PATH>,DV extends DirectoryView<DF,DK,DV,DM,DR,DL,PATH>,DM extends DirectoryModel<DF,DK,DV,DM,DR,DL,PATH>,DR extends DirectoryReference<DF,DK,DV,DM,DR,DL,PATH>,DL extends DirectoryLibrarian<DF,DK,DV,DM,DR,DL,PATH>,PATH extends Comparable<PATH>> extends FileKey<F,K,V,M,R,L> {

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


    @Override
    public L getLibrary() {
        return this.getCatalog()
    }

    public static abstract class Builder<S extends Scheme<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,L extends Library<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,LV extends LibraryView<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,LM extends LibraryModel<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,LR extends LibraryReference<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,LB extends LibraryLibrarian<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,PATH extends Comparable<PATH>,C extends Catalog<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,CV extends CatalogView<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,CM extends CatalogModel<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,CR extends CatalogReference<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,CB extends CatalogLibrarian<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,DK extends DirectoryKey<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,D extends Directory<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,DV extends DirectoryView<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,DM extends DirectoryModel<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,DR extends DirectoryReference<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,DB extends DirectoryLibrarian<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,ID extends Comparable<ID>,K extends AddressedKey<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB,ID,K,F,V,M,R,B>,F extends Addressed<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB,ID,K,F,V,M,R,B>,V extends AddressedView<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB,ID,K,F,V,M,R,B>,M extends AddressedModel<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB,ID,K,F,V,M,R,B>,R extends AddressedReference<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB,ID,K,F,V,M,R,B>,B extends AddressedLibrarian<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB,ID,K,F,V,M,R,B>> extends FileKey.Builder<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB,K,F,V,M,R,B> {

        protected ID id;
        protected DK directoryKey;

        public Builder<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB,ID,K,F,V,M,R,B> setId(ID id) {
            this.id = id;
            return this;
        }
        public Builder<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB,ID,K,F,V,M,R,B> setDirectoryKey(DK directoryKey) {
            this.directoryKey = directoryKey;
            return this;
        }
        @Override
        protected URI makeUri() {
            try {
                return new URI(this.directoryKey.getCatalog().provider().getUrlString() + this.directoryKey.directoryPath.toString() + this.id );
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
