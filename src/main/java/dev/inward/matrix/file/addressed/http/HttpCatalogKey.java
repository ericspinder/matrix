/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.http;

import dev.inward.matrix.control.catalog.CatalogKey;
import dev.inward.matrix.Range;
import dev.inward.matrix.engine.Zone;

import java.net.URI;

public class HttpCatalogKey extends CatalogKey<HttpScheme,HttpLibraryKey,HttpLibrary,HttpLibraryView,HttpLibraryModel,HttpLibraryReference, HttpLibraryLibrarian,String,HttpCatalogKey,HttpCatalog,HttpCatalogView,HttpCatalogModel,HttpCatalogReference, HttpCatalogLibrarian,HttpDirectoryLibrarian,HttpDirectoryKey,HttpDirectory,HttpDirectoryView,HttpDirectoryModel,HttpDirectoryReference, HttpDirectoryLibrarian> {
    public HttpCatalogKey(URI uri, HttpLibrary library, Range<String> range, Zone zone) {
        super(uri, library, range, zone);
    }

    public static class Builder extends CatalogKey.Builder<HttpScheme,HttpLibraryKey,HttpLibrary,HttpLibraryView,HttpLibraryModel,HttpLibraryReference, HttpLibraryLibrarian,String,HttpCatalogKey,HttpCatalog,HttpCatalogView,HttpCatalogModel,HttpCatalogReference, HttpCatalogLibrarian,HttpDirectoryLibrarian,HttpDirectoryKey,HttpDirectory,HttpDirectoryView,HttpDirectoryModel,HttpDirectoryReference, HttpDirectoryLibrarian> {

        @Override
        protected HttpCatalogKey newMatrixKey() {
            return new HttpCatalogKey(this.uri,this.library,this.range,this.zone);
        }
    }
}

