/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.log;

import dev.inward.matrix.control.catalog.CatalogView;

public class LogCatalogView extends CatalogView<LogScheme,LogLibrary,LogLibraryView,LogLibraryModel,LogLibraryReference, LogLibraryLibrarian,LogPath,LogCatalog,LogCatalogView,LogCatalogModel,LogCatalogReference,LogCatalogLibrarian,LogDirectoryKey,LogDirectory,LogDirectoryView,LogDirectoryModel,LogDirectoryReference,LogDirectoryLibrarian> {

    public LogCatalogView(String name, LogCatalog catalog, LogCatalogReference reference) {
        super(name, catalog, reference);
    }
}
