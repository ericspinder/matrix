/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.log;

import dev.inward.matrix.file.DirectoryResource;

import java.util.function.Function;

public class LogDirectoryResource extends DirectoryResource<LogScheme,LogLibraryKey,LogLibrary,LogPath,LogCatalogKey,LogCatalog,LogDirectoryKey,LogDirectory,LogDirectoryReference,LogDirectoryAttributes,LogDirectoryResource,LogDirectoryModel> {
    public LogDirectoryResource(Function<LogDirectoryReference, LogDirectoryReference> graveDigger, LogDirectoryModel model) {
        super(graveDigger, model);
    }
}
