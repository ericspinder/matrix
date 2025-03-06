/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.http;

import dev.inward.matrix.Domain;
import dev.inward.matrix.LibraryKey;

import java.net.URI;

public class HttpLibraryKey extends LibraryKey<HttpScheme,HttpLibraryKey,HttpLibrary,String,HttpCatalogKey,HttpCatalog,HttpDirectoryKey,HttpDirectory,HttpDirectoryReference,HttpDirectoryAttributes,HttpDirectoryResource,HttpDirectoryModel> {
    protected HttpLibraryKey(URI uri, HttpScheme scheme, Domain domain, int port, String separator) {
        super(uri, scheme, domain, port, separator);
    }
}
