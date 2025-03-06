/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.log;

import dev.inward.matrix.Range;
import dev.inward.matrix.file.addressed.AddressedCatalogKey;

import java.net.URI;

public class LogCatalogKey extends AddressedCatalogKey<LogScheme,LogLibraryKey,LogLibrary,LogPath,LogCatalogKey,LogCatalog,LogDirectoryKey,LogDirectory,LogDirectoryReference,LogDirectoryAttributes,LogDirectoryResource,LogDirectoryModel> {
    public LogCatalogKey(URI uri, LogLibrary library, Range<LogPath> range) {
        super(uri, library, range);
    }
}
