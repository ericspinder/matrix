/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.log;

import dev.inward.matrix.file.addressed.AddressedSteward;
import dev.inward.matrix.file.addressed.depot.specification.Specification;

import java.util.UUID;
import java.util.function.Function;

public class MatterSteward extends AddressedSteward<LogScheme,LogLibraryKey,LogLibrary,LogLibraryView,LogLibraryModel,LogLibraryReference, LogLibrarySteward,LogPath,LogCatalogKey,LogCatalog,LogCatalogView,LogCatalogModel,LogCatalogReference, LogCatalogSteward,LogDirectoryLibrarian,LogDirectoryKey,LogDirectory,LogDirectoryView,LogDirectoryModel,LogDirectoryReference, LogDirectorySteward,MatterLibrarian,UUID,MatterKey,Matter,MatterView,MatterModel,MatterReference, MatterSteward> {
    public MatterSteward(Function<MatterReference, MatterReference> graveDigger, MatterModel model, Class<MatterView> viewClass, Specification specification) {
        super(graveDigger, model,viewClass, specification);
    }
}
