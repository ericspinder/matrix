/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.http;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.control.catalog.CatalogModel;

public class HttpCatalogModel extends CatalogModel<HttpScheme,HttpLibraryKey,HttpLibrary,HttpLibraryView,HttpLibraryModel,HttpLibraryReference, HttpLibraryLibrarian,String,HttpCatalogKey,HttpCatalog,HttpCatalogView,HttpCatalogModel,HttpCatalogReference, HttpCatalogLibrarian,HttpDirectoryLibrarian,HttpDirectoryKey,HttpDirectory,HttpDirectoryView,HttpDirectoryModel,HttpDirectoryReference, HttpDirectoryLibrarian> {
    public HttpCatalogModel(Aspect[] labeledAspects) {
        super(labeledAspects);
    }
}
