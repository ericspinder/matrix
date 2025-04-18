/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file;

import dev.inward.matrix.*;
import dev.inward.matrix.control.catalog.*;
import dev.inward.matrix.control.library.*;

import java.net.URI;
import java.net.URISyntaxException;

public abstract class DirectoryKey<S extends Scheme<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,L extends Library<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,LV extends LibraryView<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,LM extends LibraryModel<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,LR extends LibraryReference<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,LB extends LibraryLibrarian<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,PATH extends Comparable<PATH>,C extends Catalog<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,CV extends CatalogView<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,CM extends CatalogModel<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,CR extends CatalogReference<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,CB extends CatalogLibrarian<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,DK extends DirectoryKey<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,D extends Directory<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,DV extends DirectoryView<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,DM extends DirectoryModel<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,DR extends DirectoryReference<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,DB extends DirectoryLibrarian<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>> extends FileKey<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB,DK,D,DV,DM,DR,DB> {

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
        return this.catalog.provider();
    }

    @Override
    public C getCatalog() {
        return catalog;
    }

    public PATH getFilePath() {
        return this.filePath;
    }

    public abstract static class Builder<S extends Scheme<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,L extends Library<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,LV extends LibraryView<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,LM extends LibraryModel<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,LR extends LibraryReference<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,LB extends LibraryLibrarian<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,PATH extends Comparable<PATH>,C extends Catalog<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,CV extends CatalogView<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,CM extends CatalogModel<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,CR extends CatalogReference<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,CB extends CatalogLibrarian<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,DK extends DirectoryKey<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,D extends Directory<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,DV extends DirectoryView<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,DM extends DirectoryModel<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,DR extends DirectoryReference<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,DB extends DirectoryLibrarian<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>> extends FileKey.Builder<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB,DK,D,DV,DM,DR,DB> {

        protected C catalog;
        protected PATH directoryPath;

        public Builder<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB> setCatalog(C catalog) {
            this.catalog = catalog;
            return this;
        }
        public Builder<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB> setDirectoryPath(PATH directoryPath) {
            this.directoryPath = directoryPath;
            return this;
        }

        @Override
        protected URI makeUri() {
            try {
                return new URI(this.catalog.provider().getUrlString() + directoryPath.toString());
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
