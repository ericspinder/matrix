/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.info;

import dev.inward.matrix.file.directory.DirectoryKey;

import java.net.URI;

public class InfoDirectoryKey extends DirectoryKey<InfoScheme,InfoLibrary,InfoLibraryView,InfoLibraryModel,InfoLibraryReference,InfoLibraryLibrarian,InfoPath,InfoCatalog,InfoCatalogView,InfoCatalogModel,InfoCatalogReference,InfoCatalogLibrarian,InfoDirectoryKey,InfoDirectory,InfoDirectoryView,InfoDirectoryModel,InfoDirectoryReference,InfoDirectoryLibrarian> {


    protected InfoDirectoryKey(URI uri, InfoCatalog catalog, InfoPath infoPath) {
        super(uri, catalog, infoPath);
    }

    public final static class Builder extends DirectoryKey.Builder<InfoScheme,InfoLibrary,InfoLibraryView,InfoLibraryModel,InfoLibraryReference,InfoLibraryLibrarian,InfoPath,InfoCatalog,InfoCatalogView,InfoCatalogModel,InfoCatalogReference,InfoCatalogLibrarian,InfoDirectoryKey,InfoDirectory,InfoDirectoryView,InfoDirectoryModel,InfoDirectoryReference,InfoDirectoryLibrarian> {

        @Override
        protected InfoDirectoryKey newMatrixKey() {
            return new InfoDirectoryKey(this.uri,this.catalog,this.directoryPath);
        }
    }
}
