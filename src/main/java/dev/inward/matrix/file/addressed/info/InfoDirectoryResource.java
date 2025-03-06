/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.info;

import dev.inward.matrix.Model;
import dev.inward.matrix.file.addressed.AddressedDirectoryResource;

import java.util.Map;
import java.util.function.Function;

public class InfoDirectoryResource extends AddressedDirectoryResource<InfoScheme,InfoLibraryKey,InfoLibrary,InfoPath,InfoCatalogKey,InfoCatalog,InfoDirectoryKey,InfoDirectory,InfoDirectoryReference,InfoDirectoryAttributes,InfoDirectoryResource,InfoDirectoryModel> {

    public InfoDirectoryResource(Function<InfoDirectoryReference, InfoDirectoryReference> graveDigger, InfoDirectoryModel model) {
        super(graveDigger, model);
    }
}
