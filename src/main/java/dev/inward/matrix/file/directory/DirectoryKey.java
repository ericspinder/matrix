/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.directory;

import dev.inward.matrix.control.catalog.*;
import dev.inward.matrix.file.FileKey;

import java.net.URI;
import java.net.URISyntaxException;

public abstract class DirectoryKey<DF extends Directory<DF,DK,DV,DM,DR,DL,PATH>,DK extends DirectoryKey<DF,DK,DV,DM,DR,DL,PATH>,DV extends DirectoryView<DF,DK,DV,DM,DR,DL,PATH>,DM extends DirectoryModel<DF,DK,DV,DM,DR,DL,PATH>,DR extends DirectoryReference<DF,DK,DV,DM,DR,DL,PATH>,DL extends DirectoryLibrarian<DF,DK,DV,DM,DR,DL,PATH>,PATH extends Comparable<PATH>> extends FileKey<DF,DK,DV,DM,DR,DL> {

    public final PATH directoryPath;

    protected DirectoryKey(URI uri, PATH directoryPath) {
        super(uri);
        this.directoryPath = directoryPath;
    }

    @Override
    public String toString() {
        return null;
    }

    public PATH getDirectoryPath() {
        return this.directoryPath;
    }
    public String getParentPathString() {
        DF directory = this.reference.get();
        if (directory != null) {
            String separator = directory.getContext().getCatalog().provider().getSeparator();
            String[] parts = this.directoryPath.toString().split(separator);
            if (parts.length == 0) {
                return null;
            }
            if (parts.length == 1) {
                return separator;
            }
            StringBuilder sb = new StringBuilder();
            for (String directoryString : parts) {
                sb.append(separator).append(directoryString);
            }
            return sb.append(separator).toString();
        }
        return null;
    }



    public abstract static class Builder<DF extends Directory<DF,DK,DV,DM,DR,DL,PATH>,DK extends DirectoryKey<DF,DK,DV,DM,DR,DL,PATH>,DV extends DirectoryView<DF,DK,DV,DM,DR,DL,PATH>,DM extends DirectoryModel<DF,DK,DV,DM,DR,DL,PATH>,DR extends DirectoryReference<DF,DK,DV,DM,DR,DL,PATH>,DL extends DirectoryLibrarian<DF,DK,DV,DM,DR,DL,PATH>,PATH extends Comparable<PATH>> extends FileKey.Builder<DF,DK,DV,DM,DR,DL> {

        protected Catalog<DF,DK,DV,DM,DR,DL,PATH> catalog;
        protected PATH directoryPath;

        public Builder<DF,DK,DV,DM,DR,DL,PATH> setCatalog(Catalog<DF,DK,DV,DM,DR,DL,PATH> catalog) {
            this.catalog = catalog;
            return this;
        }
        public Builder<DF,DK,DV,DM,DR,DL,PATH> setPath(PATH directoryPath) {
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
