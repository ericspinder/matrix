/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */


package dev.inward.matrix.file;

import dev.inward.matrix.*;

import java.net.URI;

public abstract class FileKey<S extends Scheme<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,LK extends LibraryKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,L extends Library<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,PATH extends Comparable<PATH>,CK extends CatalogKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,C extends Catalog<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DK extends DirectoryKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,D extends Directory<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DR extends DirectoryReference<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DA extends DirectoryAttributes<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DRESOURCE extends DirectoryResource<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DM extends DirectoryModel<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,K extends FileKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,K,F,R,A,RESOURCE,M>,F extends File<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,K,F,R,A,RESOURCE,M>,R extends FileReference<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,K,F,R,A,RESOURCE,M>,A extends FileAttributes<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,K,F,R,A,RESOURCE,M>,RESOURCE extends FileResource<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,K,F,R,A,RESOURCE,M>,M extends FileModel<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,K,F,R,A,RESOURCE,M>> extends MatrixKey<K,F> {

    protected R reference;

    protected FileKey(URI uri) {
        super(uri);
    }
    public R getReference() {
        return this.reference;
    }
    public void setReference(R reference) {
        if (this.reference == null && reference.get() != null && reference.get().key == this) {
            this.reference = reference;
        }
        else {
            throw new RuntimeException("Cannot reset reference");
        }
    }
    public abstract C getCatalog();

    public L getLibrary() {
        return this.getCatalog().getKey().library;
    }

    public static abstract class Builder<S extends Scheme<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,LK extends LibraryKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,L extends Library<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,PATH extends Comparable<PATH>,CK extends CatalogKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,C extends Catalog<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DK extends DirectoryKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,D extends Directory<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DR extends DirectoryReference<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DA extends DirectoryAttributes<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DRESOURCE extends DirectoryResource<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DM extends DirectoryModel<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,K extends FileKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,K,F,R,A,RESOURCE,M>,F extends File<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,K,F,R,A,RESOURCE,M>,R extends FileReference<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,K,F,R,A,RESOURCE,M>,A extends FileAttributes<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,K,F,R,A,RESOURCE,M>,RESOURCE extends FileResource<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,K,F,R,A,RESOURCE,M>,M extends FileModel<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,K,F,R,A,RESOURCE,M>> {

        protected URI uri;

        protected abstract URI makeUri();
        public final synchronized K buildFileKey() {
            this.uri = this.makeUri();
            return this.newFileKey();
        }
        protected abstract K newFileKey();
    }
}
