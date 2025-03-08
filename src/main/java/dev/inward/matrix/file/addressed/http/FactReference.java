/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.http;

import dev.inward.matrix.file.addressed.AddressedReference;


public class FactReference<K extends FactKey<K,F,R,A,RESOURCE,M>,F extends Fact<K,F,R,A,RESOURCE,M>,R extends FactReference<K,F,R,A,RESOURCE,M>,A extends FactAttribute<K,F,R,A,RESOURCE,M>,RESOURCE extends FactResource<K,F,R,A,RESOURCE,M>,M extends FactModel<K,F,R,A,RESOURCE,M>> extends AddressedReference<HttpScheme,HttpLibraryKey,HttpLibrary,String,HttpCatalogKey,HttpCatalog,HttpDirectoryKey,HttpDirectory,HttpDirectoryReference,HttpDirectoryAttributes,HttpDirectoryResource,HttpDirectoryModel,String,K,F,R,A,RESOURCE,M> {

    public FactReference(F addressed, RESOURCE resource) {
        super(addressed, resource);
    }
}
