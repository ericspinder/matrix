/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package dev.inward.matrix.file.addressed.depot;

import dev.inward.matrix.control.domain.Domain;
import dev.inward.matrix.control.library.Library;

public class DepotLibrary extends Library<DepotScheme,DepotLibrary,DepotLibraryView,DepotLibraryModel,DepotLibraryReference, DepotLibraryLibrarian,DepotPath,DepotCatalog,DepotCatalogView,DepotCatalogModel,DepotCatalogReference,DepotCatalogLibrarian,DepotDirectoryKey,DepotDirectory,DepotDirectoryView,DepotDirectoryModel,DepotDirectoryReference, DepotDirectoryLibrarian> {


    public DepotLibrary(DepotScheme scheme, Domain domain, int port, String separator) {
        super(scheme, domain, port, separator);
    }

}
