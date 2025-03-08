/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file;

import dev.inward.matrix.*;

import java.net.URI;
import java.net.URISyntaxException;

public abstract class DirectoryKey<S extends Scheme<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,LK extends LibraryKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,L extends Library<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,PATH extends Comparable<PATH>,CK extends CatalogKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,C extends Catalog<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DK extends DirectoryKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,D extends Directory<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DR extends DirectoryReference<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DA extends DirectoryAttributes<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DRESOURCE extends DirectoryResource<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DM extends DirectoryModel<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>> extends FileKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,DK,D,DR,DA,DRESOURCE,DM> {

    public final C catalog;
    public final PATH filePath;

    protected DirectoryKey(URI uri, C catalog, PATH filePath) {
        super(uri);
        this.catalog = catalog;
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public L getLibrary() {
        return this.catalog.getKey().getLibrary();
    }

    @Override
    public C getCatalog() {
        return catalog;
    }

    public PATH getFilePath() {
        return this.filePath;
    }

    public abstract static class Builder<S extends Scheme<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,LK extends LibraryKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,L extends Library<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,PATH extends Comparable<PATH>,CK extends CatalogKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,C extends Catalog<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DK extends DirectoryKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,D extends Directory<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DR extends DirectoryReference<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DA extends DirectoryAttributes<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DRESOURCE extends DirectoryResource<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DM extends DirectoryModel<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>> extends FileKey.Builder<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,DK,D,DR,DA,DRESOURCE,DM> {

        protected C catalog;
        protected PATH directoryPath;

        public Builder<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM> setCatalog(C catalog) {
            this.catalog = catalog;
            return this;
        }
        public Builder<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM> setDirectoryPath(PATH directoryPath) {
            this.directoryPath = directoryPath;
            return this;
        }

        @Override
        protected URI makeUri() {
            try {
                return new URI(this.catalog.getKey().getLibrary().getKey().getMatrixPath().toUri() + directoryPath.toString());
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
