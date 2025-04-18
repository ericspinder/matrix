/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.log;

import dev.inward.matrix.control.catalog.CatalogKey;
import dev.inward.matrix.Range;
import dev.inward.matrix.engine.Zone;

import java.net.URI;

public class LogCatalogKey extends CatalogKey<LogScheme,LogLibraryKey,LogLibrary,LogLibraryView,LogLibraryModel,LogLibraryReference, LogLibraryLibrarian,LogPath,LogCatalogKey,LogCatalog,LogCatalogView,LogCatalogModel,LogCatalogReference, LogCatalogLibrarian,LogDirectoryLibrarian,LogDirectoryKey,LogDirectory,LogDirectoryView,LogDirectoryModel,LogDirectoryReference, LogDirectoryLibrarian> {
    public LogCatalogKey(URI uri, LogLibrary library, Range<LogPath> range, Zone zone) {
        super(uri, library, range, zone);
    }

    public static class Builder extends CatalogKey.Builder<LogScheme,LogLibraryKey,LogLibrary,LogLibraryView,LogLibraryModel,LogLibraryReference, LogLibraryLibrarian,LogPath,LogCatalogKey,LogCatalog,LogCatalogView,LogCatalogModel,LogCatalogReference, LogCatalogLibrarian,LogDirectoryLibrarian,LogDirectoryKey,LogDirectory,LogDirectoryView,LogDirectoryModel,LogDirectoryReference, LogDirectoryLibrarian> {

        @Override
        protected LogCatalogKey newMatrixKey() {
            return new LogCatalogKey(this.uri,this.library, this.range, this.zone);
        }
    }


}
