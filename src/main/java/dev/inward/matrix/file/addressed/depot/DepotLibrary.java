/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package dev.inward.matrix.file.addressed.depot;

import dev.inward.matrix.control.library.Library;
import dev.inward.matrix.memory.bureau.Bureau;
import dev.inward.matrix.file.addressed.depot.indica.Indica;

import java.util.Map;

public class DepotLibrary extends Library<DepotScheme,DepotLibraryKey,DepotLibrary,DepotLibraryView,DepotLibraryModel,DepotLibraryReference, DepotLibraryLibrarian,DepotPath,DepotCatalogKey,DepotCatalog,DepotCatalogView,DepotCatalogModel,DepotCatalogReference, DepotCatalogLibrarian,DepotDirectoryLibrarian,DepotDirectoryKey,DepotDirectory,DepotDirectoryView,DepotDirectoryModel,DepotDirectoryReference, DepotDirectoryLibrarian> {


    public DepotLibrary(DepotLibraryKey libraryKey) {
        super(libraryKey);
    }

    @Override
    protected Map<DepotCatalog, Bureau<?, ?, ?, ?>[]> initCatalogs() {
        return null;
    }


    public Indica matchIndicaKey(String indicaKeyName) {
        return null;
    }
}
