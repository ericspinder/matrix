/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package dev.inward.matrix.file.addressed.http;

import dev.inward.matrix.control.domain.Domain;
import dev.inward.matrix.control.library.Library;
import dev.inward.matrix.memory.bureau.Bureau;

import java.util.Map;

public class HttpLibrary extends Library<HttpScheme,HttpLibrary,HttpLibraryView,HttpLibraryModel,HttpLibraryReference,HttpLibraryLibrarian,String,HttpCatalog,HttpCatalogView,HttpCatalogModel,HttpCatalogReference, HttpCatalogLibrarian,HttpDirectoryKey,HttpDirectory,HttpDirectoryView,HttpDirectoryModel,HttpDirectoryReference,HttpDirectoryLibrarian> {

    public HttpLibrary(HttpScheme scheme, Domain domain, int port, String separator) {
        super(scheme, domain, port, separator);
    }

    @Override
    protected Map<HttpCatalog, Bureau<?, ?, ?, ?, ?, ?, ?>[]> initCatalogs() {
        return null;
    }
}
