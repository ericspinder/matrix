/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package dev.inward.matrix.file.addressed.http;

import dev.inward.matrix.Library;
import dev.inward.matrix.bureau.Bureau;

import java.util.Map;

public class HttpLibrary extends Library<HttpScheme,HttpLibraryKey,HttpLibrary,String,HttpCatalogKey,HttpCatalog,HttpDirectoryKey,HttpDirectory,HttpDirectoryReference,HttpDirectoryAttributes,HttpDirectoryResource,HttpDirectoryModel> {
    public HttpLibrary(HttpLibraryKey libraryKey) {
        super(libraryKey);
    }

    @Override
    protected Map<HttpCatalog, Bureau<HttpScheme, HttpLibraryKey, HttpLibrary, String, HttpCatalogKey, HttpCatalog, HttpDirectoryKey, HttpDirectory, HttpDirectoryReference, HttpDirectoryAttributes, HttpDirectoryResource, HttpDirectoryModel>[]> initCatalogs() {
        return null;
    }
}
