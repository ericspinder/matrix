/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.depot;

import dev.inward.matrix.control.library.LibraryLibrarian;
import dev.inward.matrix.file.addressed.depot.standard.Standard;

public class DepotLibraryLibrarian extends LibraryLibrarian<DepotScheme,DepotLibraryKey,DepotLibrary,DepotLibraryView,DepotLibraryModel,DepotLibraryReference, DepotLibraryLibrarian,DepotPath,DepotCatalogKey,DepotCatalog,DepotCatalogView,DepotCatalogModel,DepotCatalogReference, DepotCatalogLibrarian,DepotDirectoryLibrarian,DepotDirectoryKey,DepotDirectory,DepotDirectoryView,DepotDirectoryModel,DepotDirectoryReference, DepotDirectoryLibrarian> {
    public DepotLibraryLibrarian(Standard standard) {
        super(standard);
    }
}
