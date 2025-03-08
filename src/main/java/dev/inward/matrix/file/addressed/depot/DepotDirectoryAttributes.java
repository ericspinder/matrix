/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.depot;

import dev.inward.matrix.Model;
import dev.inward.matrix.file.DirectoryAttributes;

import java.util.Map;

public class DepotDirectoryAttributes extends DirectoryAttributes<DepotScheme,DepotLibraryKey, DepotLibrary, DepotPath,DepotCatalogKey,DepotCatalog,DepotDirectoryKey,DepotDirectory,DepotDirectoryReference,DepotDirectoryAttributes,DepotDirectoryResource,DepotDirectoryModel> {
    public DepotDirectoryAttributes(Map<String, Model.InstanceValue> properties) {
        super(properties);
    }
}
