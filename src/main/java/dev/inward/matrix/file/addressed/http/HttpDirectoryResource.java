/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.http;

import dev.inward.matrix.file.addressed.AddressedDirectoryResource;

import java.util.function.Function;

public class HttpDirectoryResource extends AddressedDirectoryResource<HttpScheme,HttpLibraryKey,HttpLibrary,String,HttpCatalogKey,HttpCatalog,HttpDirectoryKey,HttpDirectory,HttpDirectoryReference,HttpDirectoryAttributes,HttpDirectoryResource,HttpDirectoryModel> {
    public HttpDirectoryResource(Function<HttpDirectoryReference, HttpDirectoryReference> graveDigger, HttpDirectoryModel model) {
        super(graveDigger, model);
    }
}
