/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.http;

import dev.inward.matrix.Catalog;

public class HttpCatalog extends Catalog<HttpScheme,HttpLibraryKey,HttpLibrary,String,HttpCatalogKey,HttpCatalog,HttpDirectoryKey,HttpDirectory,HttpDirectoryReference,HttpDirectoryAttributes,HttpDirectoryResource,HttpDirectoryModel> {
    public HttpCatalog(HttpCatalogKey catalogKey) {
        super(catalogKey);
    }

    @Override
    protected boolean init(HttpCatalogKey catalogKey) {
        return false;
    }

    @Override
    protected HttpDirectoryKey createDirectoryKey(String s) {
        return null;
    }
}
