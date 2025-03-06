/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.depot;

import dev.inward.matrix.Range;
import dev.inward.matrix.file.addressed.AddressedCatalogKey;
import dev.inward.matrix.file.addressed.AddressedLibrary;

import java.net.URI;

public class DepotCatalogKey extends AddressedCatalogKey<DepotScheme, DepotLibraryKey,DepotLibrary, DepotPath,DepotCatalogKey,DepotCatalog,DepotDirectoryKey,DepotDirectory,DepotDirectoryReference,DepotDirectoryAttributes,DepotDirectoryResource,DepotDirectoryModel> {
    public DepotCatalogKey(URI uri, DepotLibrary library, Range<DepotPath> range) {
        super(uri, library, range);
    }
}
