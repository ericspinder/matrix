/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.info;

import dev.inward.matrix.file.addressed.AddressedGestalt;
import dev.inward.matrix.file.addressed.depot.specification.Specification;

import java.util.function.Function;

public class PrivilegeGestalt<K extends PrivilegeKey<K,F,R, V,RESOURCE,M>,F extends Privilege<K,F,R, V,RESOURCE,M>,R extends PrivilegeReference<K,F,R, V,RESOURCE,M>, V extends PrivilegeView<K,F,R, V,RESOURCE,M>,RESOURCE extends PrivilegeGestalt<K,F,R, V,RESOURCE,M>,M extends PrivilegeModel<K,F,R, V,RESOURCE,M>> extends AddressedGestalt<InfoScheme,InfoLibraryKey,InfoLibrary,InfoPath,InfoCatalogKey,InfoCatalog,InfoDirectoryKey,InfoDirectory,InfoDirectoryReference, InfoDirectoryView, InfoDirectoryGestalt,InfoDirectoryModel,String,K,F,R, V,RESOURCE,M> {
    public PrivilegeGestalt(Function<R, R> graveDigger, M model, Class<V> viewClass, Specification specification) {
        super(graveDigger, model, viewClass, specification);
    }
}
