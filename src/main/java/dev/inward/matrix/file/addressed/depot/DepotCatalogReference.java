/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.depot;

import dev.inward.matrix.control.catalog.CatalogReference;

public class DepotCatalogReference extends CatalogReference<DepotScheme,DepotLibrary,DepotLibraryView,DepotLibraryModel,DepotLibraryReference,DepotLibraryLibrarian,DepotPath,DepotCatalog,DepotCatalogView,DepotCatalogModel,DepotCatalogReference,DepotCatalogLibrarian,DepotDirectoryKey,DepotDirectory,DepotDirectoryView,DepotDirectoryModel,DepotDirectoryReference, DepotDirectoryLibrarian> {
    public DepotCatalogReference(DepotCatalog referent, DepotCatalogLibrarian gestalt) {
        super(referent, gestalt);
    }
}
