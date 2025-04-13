/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.log;

import dev.inward.matrix.file.addressed.AddressedGestalt;
import dev.inward.matrix.file.addressed.depot.specification.Specification;

import java.util.UUID;
import java.util.function.Function;

public class MatterGestalt extends AddressedGestalt<LogScheme,LogLibraryKey,LogLibrary,LogLibraryView,LogLibraryModel,LogPath,LogCatalogKey,LogCatalog,LogCatalogView,LogCatalogModel,LogDirectoryLibrarian,LogDirectoryKey,LogDirectory,LogDirectoryView,LogDirectoryModel,LogDirectoryReference, LogDirectoryGestalt,MatterLibrarian,UUID,MatterKey,Matter,MatterView,MatterModel,MatterReference, MatterGestalt> {
    public MatterGestalt(Function<MatterReference, MatterReference> graveDigger, MatterModel model, Class<MatterView> viewClass, Specification specification) {
        super(graveDigger, model,viewClass, specification);
    }
}
