/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.log;

import dev.inward.matrix.container.catalog.Catalog;

import java.net.URI;
import java.net.URISyntaxException;

public class LogCatalog extends Catalog<LogScheme,LogLibraryKey,LogLibrary,LogLibraryView,LogLibraryModel,LogLibraryReference, LogLibrarySteward,LogPath,LogCatalogKey,LogCatalog,LogCatalogView,LogCatalogModel,LogCatalogReference, LogCatalogSteward,LogDirectoryLibrarian,LogDirectoryKey,LogDirectory,LogDirectoryView,LogDirectoryModel,LogDirectoryReference, LogDirectorySteward> {

    public LogCatalog(LogCatalogKey catalogKey) {
        super(catalogKey);
    }

    @Override
    protected boolean init(LogCatalogKey catalogKey) {
        return false;
    }

    @Override
    protected LogDirectoryKey createDirectoryKey(LogPath logPath) {
        try {
            return new LogDirectoryKey(new URI(this.getKey().getLibrary().getKey().toUri() + logPath.toString()),this,logPath);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
