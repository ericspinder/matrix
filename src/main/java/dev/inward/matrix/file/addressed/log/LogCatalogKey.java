/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.log;

import dev.inward.matrix.CatalogKey;
import dev.inward.matrix.Range;

import java.net.URI;

public class LogCatalogKey extends CatalogKey<LogScheme,LogLibraryKey,LogLibrary,LogPath,LogCatalogKey,LogCatalog,LogDirectoryKey,LogDirectory,LogDirectoryReference,LogDirectoryAttributes,LogDirectoryResource,LogDirectoryModel> {
    public LogCatalogKey(URI uri, LogLibrary library, Range<LogPath> range) {
        super(uri, library, range);
    }
}
