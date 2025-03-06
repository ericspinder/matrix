/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.depot;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.file.addressed.AddressedDirectoryModel;

public class DepotDirectoryModel extends AddressedDirectoryModel<DepotScheme,DepotLibraryKey, DepotLibrary, DepotPath,DepotCatalogKey,DepotCatalog,DepotDirectoryKey,DepotDirectory,DepotDirectoryReference,DepotDirectoryAttributes,DepotDirectoryResource,DepotDirectoryModel> {
    public DepotDirectoryModel(Aspect[] labeledAspects, long warnOnTotal, long hardLimit) {
        super(labeledAspects, warnOnTotal, hardLimit);
    }
}
