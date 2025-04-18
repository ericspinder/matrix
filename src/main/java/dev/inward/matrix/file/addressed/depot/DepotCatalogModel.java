/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.depot;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.control.catalog.CatalogModel;

public class DepotCatalogModel extends CatalogModel<DepotScheme,DepotLibraryKey,DepotLibrary,DepotLibraryView,DepotLibraryModel,DepotLibraryReference, DepotLibrarySteward,DepotPath,DepotCatalogKey,DepotCatalog,DepotCatalogView,DepotCatalogModel,DepotCatalogReference, DepotCatalogSteward,DepotDirectoryLibrarian,DepotDirectoryKey,DepotDirectory,DepotDirectoryView,DepotDirectoryModel,DepotDirectoryReference, DepotDirectorySteward> {
    public DepotCatalogModel(Aspect[] labeledAspects) {
        super(labeledAspects);
    }
}
