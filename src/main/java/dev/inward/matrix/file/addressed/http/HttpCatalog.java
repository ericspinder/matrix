/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.http;

import dev.inward.matrix.Range;
import dev.inward.matrix.control.catalog.Catalog;
import dev.inward.matrix.engine.Zone;

public class HttpCatalog extends Catalog<HttpScheme,HttpLibrary,HttpLibraryView,HttpLibraryModel,HttpLibraryReference,HttpLibraryLibrarian,String,HttpCatalog,HttpCatalogView,HttpCatalogModel,HttpCatalogReference, HttpCatalogLibrarian,HttpDirectoryKey,HttpDirectory,HttpDirectoryView,HttpDirectoryModel,HttpDirectoryReference,HttpDirectoryLibrarian> {

    public HttpCatalog(HttpLibrary library, Range<String> range, Zone zone) {
        super(library, range, zone);
    }

    @Override
    protected void init() {

    }

    @Override
    protected HttpDirectoryKey newDirectoryKey(String path) {
        return null;
    }
}
