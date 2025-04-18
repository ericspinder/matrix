/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.info;

import dev.inward.matrix.control.catalog.CatalogReference;

public class InfoCatalogReference extends CatalogReference<InfoScheme,InfoLibraryKey,InfoLibrary,InfoLibraryView,InfoLibraryModel,InfoLibraryReference, InfoLibraryLibrarian,InfoPath,InfoCatalogKey,InfoCatalog,InfoCatalogView,InfoCatalogModel,InfoCatalogReference, InfoCatalogLibrarian,InfoDirectoryLibrarian,InfoDirectoryKey,InfoDirectory,InfoDirectoryView,InfoDirectoryModel,InfoDirectoryReference, InfoDirectoryLibrarian> {
    public InfoCatalogReference(InfoCatalog referent, InfoCatalogLibrarian gestalt) {
        super(referent, gestalt);
    }
}
