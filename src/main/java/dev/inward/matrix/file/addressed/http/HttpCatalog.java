/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.http;

import dev.inward.matrix.control.catalog.Catalog;

public class HttpCatalog extends Catalog<HttpScheme,HttpLibraryKey,HttpLibrary,HttpLibraryView,HttpLibraryModel,HttpLibraryReference, HttpLibraryLibrarian,String,HttpCatalogKey,HttpCatalog,HttpCatalogView,HttpCatalogModel,HttpCatalogReference, HttpCatalogLibrarian,HttpDirectoryLibrarian,HttpDirectoryKey,HttpDirectory,HttpDirectoryView,HttpDirectoryModel,HttpDirectoryReference, HttpDirectoryLibrarian> {
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
