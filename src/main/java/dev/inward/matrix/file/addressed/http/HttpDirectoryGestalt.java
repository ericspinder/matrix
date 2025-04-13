/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.http;

import dev.inward.matrix.file.DirectoryGestalt;

import java.util.function.Function;

public class HttpDirectoryGestalt extends DirectoryGestalt<HttpScheme,HttpLibraryKey,HttpLibrary,String,HttpCatalogKey,HttpCatalog,HttpDirectoryKey,HttpDirectory,HttpDirectoryReference, HttpDirectoryView, HttpDirectoryGestalt,HttpDirectoryModel> {
    public HttpDirectoryGestalt(Function<HttpDirectoryReference, HttpDirectoryReference> graveDigger, HttpDirectoryModel model, Class<HttpDirectoryView> viewClass) {
        super(graveDigger, model,viewClass);
    }
}
