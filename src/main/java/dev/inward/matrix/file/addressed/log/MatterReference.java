/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.log;

import dev.inward.matrix.file.addressed.AddressedReference;

import java.util.UUID;

public class MatterReference extends AddressedReference<LogScheme,LogLibraryKey,LogLibrary,LogPath,LogCatalogKey,LogCatalog,LogDirectoryKey,LogDirectory,LogDirectoryReference,LogDirectoryAttributes,LogDirectoryResource,LogDirectoryModel,UUID,MatterKey,Matter,MatterReference,MatterAttributes,MatterResource,MatterModel> {
    public MatterReference(Matter addressed, MatterResource resource) {
        super(addressed, resource);
    }
}
