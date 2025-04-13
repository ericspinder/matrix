/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.depot;

import dev.inward.matrix.file.DirectoryGestalt;

import java.util.function.Function;

public class DepotDirectoryGestalt extends DirectoryGestalt<DepotScheme, DepotLibraryKey,DepotLibrary, DepotPath,DepotCatalogKey,DepotCatalog,DepotDirectoryKey,DepotDirectory,DepotDirectoryReference, DepotDirectoryView, DepotDirectoryGestalt,DepotDirectoryModel> {
    public DepotDirectoryGestalt(Function<DepotDirectoryReference, DepotDirectoryReference> graveDigger, DepotDirectoryModel model, Class<DepotDirectoryView> viewClass) {
        super(graveDigger, model, viewClass);
    }
}
