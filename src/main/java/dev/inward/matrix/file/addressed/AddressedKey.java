/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed;

import dev.inward.matrix.Library;
import dev.inward.matrix.LibraryKey;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.file.FileKey;

import java.net.URI;
import java.net.URISyntaxException;

public abstract class AddressedKey<S extends Scheme<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,LK extends LibraryKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,L extends Library<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,PATH extends Comparable<PATH>,CK extends AddressedCatalogKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,C extends AddressedCatalog<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DK extends AddressedDirectoryKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,D extends AddressedDirectory<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DR extends AddressedDirectoryReference<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DA extends AddressedDirectoryAttributes<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DRESOURCE extends AddressedDirectoryResource<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DM extends AddressedDirectoryModel<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,ID extends Comparable<ID>,K extends AddressedKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,ID,K,F,R,A,RESOURCE,M>,F extends Addressed<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,ID,K,F,R,A,RESOURCE,M>,R extends AddressedReference<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,ID,K,F,R,A,RESOURCE,M>,A extends AddressedAttributes<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,ID,K,F,R,A,RESOURCE,M>,RESOURCE extends AddressedResource<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,ID,K,F,R,A,RESOURCE,M>,M extends AddressedModel<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,ID,K,F,R,A,RESOURCE,M>> extends FileKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,K,F,R,A,RESOURCE,M> {

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
    public C getCatalog() {
        return directoryKey.getCatalog();
    }

    @Override
    public L getLibrary() {
        return directoryKey.getCatalog().getKey().getLibrary();
    }

    public static abstract class Builder<S extends Scheme<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,LK extends LibraryKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,L extends Library<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,PATH extends Comparable<PATH>,CK extends AddressedCatalogKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,C extends AddressedCatalog<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DK extends AddressedDirectoryKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,D extends AddressedDirectory<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DR extends AddressedDirectoryReference<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DA extends AddressedDirectoryAttributes<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DRESOURCE extends AddressedDirectoryResource<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DM extends AddressedDirectoryModel<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,ID extends Comparable<ID>,K extends AddressedKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,ID,K,F,R,A,RESOURCE,M>,F extends Addressed<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,ID,K,F,R,A,RESOURCE,M>,R extends AddressedReference<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,ID,K,F,R,A,RESOURCE,M>,A extends AddressedAttributes<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,ID,K,F,R,A,RESOURCE,M>,RESOURCE extends AddressedResource<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,ID,K,F,R,A,RESOURCE,M>,M extends AddressedModel<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,ID,K,F,R,A,RESOURCE,M>> extends FileKey.Builder<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,K,F,R,A,RESOURCE,M> {

        protected ID id;
        protected DK directoryKey;

        public Builder<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,ID,K,F,R,A,RESOURCE,M> setId(ID id) {
            this.id = id;
            return this;
        }
        public Builder<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,ID,K,F,R,A,RESOURCE,M> setDirectoryKey(DK directoryKey) {
            this.directoryKey = directoryKey;
            return this;
        }
        @Override
        protected URI makeUri() {
            try {
                return new URI(this.directoryKey.getCatalog().getKey().getLibrary().getKey().getUri() + this.directoryKey.getFilePath().toString() + this.id );
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
