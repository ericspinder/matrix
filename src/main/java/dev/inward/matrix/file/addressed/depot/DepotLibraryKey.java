/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.depot;

import dev.inward.matrix.control.domain.Domain;
import dev.inward.matrix.control.library.LibraryKey;

import java.net.URI;

public class DepotLibraryKey extends LibraryKey<DepotScheme,DepotLibraryKey,DepotLibrary,DepotLibraryView,DepotLibraryModel,DepotLibraryReference, DepotLibraryLibrarian,DepotPath,DepotCatalogKey,DepotCatalog,DepotCatalogView,DepotCatalogModel,DepotCatalogReference, DepotCatalogLibrarian,DepotDirectoryLibrarian,DepotDirectoryKey,DepotDirectory,DepotDirectoryView,DepotDirectoryModel,DepotDirectoryReference, DepotDirectoryLibrarian> {
    protected DepotLibraryKey(URI uri, DepotScheme scheme, Domain domain, int port, String separator) {
        super(uri, scheme, domain, port, separator);
    }
}
