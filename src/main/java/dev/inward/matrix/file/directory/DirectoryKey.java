/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.directory;

import dev.inward.matrix.control.catalog.*;
import dev.inward.matrix.control.library.*;
import dev.inward.matrix.control.scheme.Scheme;
import dev.inward.matrix.file.FileKey;

import java.net.URI;
import java.net.URISyntaxException;

public abstract class DirectoryKey<DF extends Directory<DF,DK,DV,DM,DR,DL,PATH>,DK extends DirectoryKey<DF,DK,DV,DM,DR,DL,PATH>,DV extends DirectoryView<DF,DK,DV,DM,DR,DL,PATH>,DM extends DirectoryModel<DF,DK,DV,DM,DR,DL,PATH>,DR extends DirectoryReference<DF,DK,DV,DM,DR,DL,PATH>,DL extends DirectoryLibrarian<DF,DK,DV,DM,DR,DL,PATH>,PATH extends Comparable<PATH>> extends FileKey<DF,DK,DV,DM,DR,DL,DF,DK,DV,DM,DR,DL,PATH> {

    public final PATH directoryPath;

    protected DirectoryKey(URI uri, PATH directoryPath) {
        super(uri);
        this.directoryPath = directoryPath;
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

    public PATH getDirectoryPath() {
        return this.directoryPath;
    }
    public String getParentPathString() {
        String[] parts = this.directoryPath.toString().split(this.catalog.provider().getSeparator());
        if (parts.length == 0) {
            return null;
        }
        if (parts.length == 1) {
            return this.getCatalog().provider().getSeparator();
        }
        StringBuilder sb = new StringBuilder();
        for (String directoryString: parts) {
            sb.append(this.catalog.provider().getSeparator()).append(directoryString).append(this.catalog.provider().getSeparator());
        }
        return sb.toString();
    }



    public abstract static class Builder<S extends Scheme<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,L extends Library<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,LV extends LibraryView<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,LM extends LibraryModel<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,LR extends LibraryReference<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,LB extends LibraryLibrarian<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,PATH extends Comparable<PATH>,C extends Catalog<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,CV extends CatalogView<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,CM extends CatalogModel<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,CR extends CatalogReference<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,CB extends CatalogLibrarian<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,DK extends DirectoryKey<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,D extends Directory<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,DV extends DirectoryView<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,DM extends DirectoryModel<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,DR extends DirectoryReference<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,DB extends DirectoryLibrarian<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>> extends FileKey.Builder<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB,DK,D,DV,DM,DR,DB> {

        protected C catalog;
        protected PATH directoryPath;

        public Builder<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB> setCatalog(C catalog) {
            this.catalog = catalog;
            return this;
        }
        public Builder<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB> setPath(PATH directoryPath) {
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
