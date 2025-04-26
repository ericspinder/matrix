/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.depot;

import dev.inward.matrix.Range;
import dev.inward.matrix.control.catalog.Catalog;
import dev.inward.matrix.engine.Zone;

public class DepotCatalog extends Catalog<DepotScheme,DepotLibrary,DepotLibraryView,DepotLibraryModel,DepotLibraryReference, DepotLibraryLibrarian,DepotPath,DepotCatalog,DepotCatalogView,DepotCatalogModel,DepotCatalogReference,DepotCatalogLibrarian,DepotDirectoryKey,DepotDirectory,DepotDirectoryView,DepotDirectoryModel,DepotDirectoryReference, DepotDirectoryLibrarian> {
    public DepotCatalog(DepotLibrary library, Range<DepotPath> range, Zone zone) {
        super(library, range, zone);
    }

    @Override
    protected void init() {

    }

    @Override
    protected DepotDirectoryKey newDirectoryKey(String path) {
        return null;
    }
}
