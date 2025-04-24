/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.info;

import dev.inward.matrix.file.DirectoryKey;

import java.net.URI;
import java.net.URISyntaxException;

public class InfoDirectoryKey extends DirectoryKey<InfoScheme,InfoLibrary,InfoLibraryView,InfoLibraryModel,InfoLibraryReference,InfoLibraryLibrarian,InfoPath,InfoCatalog,InfoCatalogView,InfoCatalogModel,InfoCatalogReference,InfoCatalogLibrarian,InfoDirectoryKey,InfoDirectory,InfoDirectoryView,InfoDirectoryModel,InfoDirectoryReference,InfoDirectoryLibrarian> {


    protected InfoDirectoryKey(URI uri, InfoCatalog catalog, InfoPath infoPath) {
        super(uri, catalog, infoPath);
    }

    public final static class Builder extends DirectoryKey.Builder<InfoScheme,InfoLibrary,InfoLibraryView,InfoLibraryModel,InfoLibraryReference,InfoLibraryLibrarian,InfoPath,InfoCatalog,InfoCatalogView,InfoCatalogModel,InfoCatalogReference,InfoCatalogLibrarian,InfoDirectoryKey,InfoDirectory,InfoDirectoryView,InfoDirectoryModel,InfoDirectoryReference,InfoDirectoryLibrarian> {

        private final URI uri;
        private final InfoPath infoPath;
        private final InfoCatalog infoCatalog;

        public Builder(InfoCatalog infoCatalog, InfoPath infoPath) {
            this.infoCatalog = infoCatalog;
            this.infoPath = infoPath;
            try {
                this.uri = new URI(infoCatalog.getKey().toUri().getScheme(), infoCatalog.getKey().toUri().getAuthority(),infoPath.toString(),null,null);
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }

        public InfoDirectoryKey buildKey() {
            return new InfoDirectoryKey(this.uri,this.infoCatalog,this.infoPath);
        }

        @Override
        protected InfoDirectoryKey newMatrixKey() {
            return new InfoDirectoryKey(this.uri,this.infoCatalog,this.infoPath);
        }
    }
}
