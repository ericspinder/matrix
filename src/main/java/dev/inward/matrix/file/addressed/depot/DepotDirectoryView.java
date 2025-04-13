/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.depot;

import dev.inward.matrix.Model;
import dev.inward.matrix.file.DirectoryView;

import java.util.Map;

public class DepotDirectoryView extends DirectoryView<DepotScheme,DepotLibraryKey, DepotLibrary, DepotPath,DepotCatalogKey,DepotCatalog,DepotDirectoryKey,DepotDirectory,DepotDirectoryReference, DepotDirectoryView,DepotDirectoryResource,DepotDirectoryModel> {
    public DepotDirectoryView(Map<String, Model.InstanceValue> properties) {
        super(properties);
    }
}
