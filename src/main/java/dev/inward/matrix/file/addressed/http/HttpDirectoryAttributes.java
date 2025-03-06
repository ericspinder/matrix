/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.http;

import dev.inward.matrix.Model;
import dev.inward.matrix.file.addressed.AddressedDirectoryAttributes;

import java.util.Map;

public class HttpDirectoryAttributes extends AddressedDirectoryAttributes<HttpScheme,HttpLibraryKey,HttpLibrary,String,HttpCatalogKey,HttpCatalog,HttpDirectoryKey,HttpDirectory,HttpDirectoryReference,HttpDirectoryAttributes,HttpDirectoryResource,HttpDirectoryModel> {
    public HttpDirectoryAttributes(Map<String, Model.InstanceValue> properties) {
        super(properties);
    }
}
