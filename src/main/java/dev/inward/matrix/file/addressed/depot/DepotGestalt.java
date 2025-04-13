/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.depot;

import dev.inward.matrix.file.addressed.AddressedGestalt;
import dev.inward.matrix.file.addressed.depot.specification.Specification;

import java.util.function.Function;

public class DepotGestalt<K extends DepotKey<K,F,R, V,RESOURCE,M>,F extends Depot<K,F,R, V,RESOURCE,M>,R extends DepotReference<K,F,R, V,RESOURCE,M>, V extends DepotView<K,F,R, V,RESOURCE,M>,RESOURCE extends DepotGestalt<K,F,R, V,RESOURCE,M>,M extends DepotModel<K,F,R, V,RESOURCE,M>> extends AddressedGestalt<DepotScheme, DepotLibraryKey,DepotLibrary, DepotPath,DepotCatalogKey,DepotCatalog,DepotDirectoryKey,DepotDirectory,DepotDirectoryReference, DepotDirectoryView, DepotDirectoryGestalt,DepotDirectoryModel,String,K,F,R, V,RESOURCE,M> {

    public DepotGestalt(Function<R,R> graveDigger, M model, Class<V> viewClass, Specification specification) {
        super(graveDigger, model, viewClass, specification);
    }
}
