/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.log;

import dev.inward.matrix.file.addressed.AddressedResource;
import dev.inward.matrix.file.addressed.depot.specification.Specification;

import java.util.UUID;
import java.util.function.Function;

public class MatterResource extends AddressedResource<LogScheme,LogLibraryKey,LogLibrary,LogPath,LogCatalogKey,LogCatalog,LogDirectoryKey,LogDirectory,LogDirectoryReference,LogDirectoryAttributes,LogDirectoryResource,LogDirectoryModel,UUID,MatterKey,Matter,MatterReference,MatterAttributes,MatterResource,MatterModel> {
    public MatterResource(Function<MatterReference, MatterReference> graveDigger, MatterModel model, Specification specification) {
        super(graveDigger, model, specification);
    }
}
