/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.log;

import dev.inward.matrix.Range;
import dev.inward.matrix.control.catalog.Catalog;
import dev.inward.matrix.engine.Zone;

import java.net.URI;
import java.net.URISyntaxException;

public class LogCatalog extends Catalog<LogScheme,LogLibrary,LogLibraryView,LogLibraryModel,LogLibraryReference, LogLibraryLibrarian,LogPath,LogCatalog,LogCatalogView,LogCatalogModel,LogCatalogReference,LogCatalogLibrarian,LogDirectoryKey,LogDirectory,LogDirectoryView,LogDirectoryModel,LogDirectoryReference,LogDirectoryLibrarian> {


    public LogCatalog(LogLibrary library, Range<LogPath> range, Zone zone) {
        super(library, range, zone);
    }

    @Override
    protected void init() {

    }

    @Override
    protected LogDirectoryKey newDirectoryKey(String path) {
        return null;
    }
}
