/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.http;

import dev.inward.matrix.file.addressed.AddressedGestalt;
import dev.inward.matrix.file.addressed.depot.specification.Specification;

import java.util.function.Function;

public class FactGestalt<K extends FactKey<K,F,R,A,RESOURCE,M>,F extends Fact<K,F,R,A,RESOURCE,M>,R extends FactReference<K,F,R,A,RESOURCE,M>,A extends FactView<K,F,R,A,RESOURCE,M>,RESOURCE extends FactGestalt<K,F,R,A,RESOURCE,M>,M extends FactModel<K,F,R,A,RESOURCE,M>> extends AddressedGestalt<HttpScheme,HttpLibraryKey,HttpLibrary,String,HttpCatalogKey,HttpCatalog,HttpDirectoryKey,HttpDirectory,HttpDirectoryReference, HttpDirectoryView, HttpDirectoryGestalt,HttpDirectoryModel,String,K,F,R,A,RESOURCE,M> {
    public FactGestalt(Function<R, R> graveDigger, M model, Class<A> viewClass, Specification specification) {
        super(graveDigger, model, viewClass, specification);
    }
}
