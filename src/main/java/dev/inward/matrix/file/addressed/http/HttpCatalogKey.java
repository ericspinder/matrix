/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.http;

import dev.inward.matrix.CatalogKey;
import dev.inward.matrix.Range;

import java.net.URI;

public class HttpCatalogKey extends CatalogKey<HttpScheme,HttpLibraryKey,HttpLibrary,String,HttpCatalogKey,HttpCatalog,HttpDirectoryKey,HttpDirectory,HttpDirectoryReference,HttpDirectoryAttributes,HttpDirectoryResource,HttpDirectoryModel> {
    public HttpCatalogKey(URI uri, HttpLibrary library, Range<String> range) {
        super(uri, library, range);
    }
}
