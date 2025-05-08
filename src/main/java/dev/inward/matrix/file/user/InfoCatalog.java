/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.user;

import dev.inward.matrix.Range;
import dev.inward.matrix.control.catalog.Catalog;
import dev.inward.matrix.engine.Zone;

public class InfoCatalog extends Catalog<InfoScheme,InfoLibrary,InfoLibraryView,InfoLibraryModel,InfoLibraryReference,InfoLibraryLibrarian,InfoPath,InfoCatalog,InfoCatalogView,InfoCatalogModel,InfoCatalogReference,InfoCatalogLibrarian,InfoDirectoryKey,InfoDirectory,InfoDirectoryView,InfoDirectoryModel,InfoDirectoryReference,InfoDirectoryLibrarian> {

    public InfoCatalog(InfoLibrary library, Range<InfoPath> range, Zone zone) {
        super(library, range, zone);
    }

    @Override
    protected void init() {

    }

    @Override
    protected InfoDirectoryKey newDirectoryKey(String path) {
        return null;
    }
}
