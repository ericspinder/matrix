/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.depot;

import dev.inward.matrix.file.addressed.AddressedSteward;
import dev.inward.matrix.file.addressed.depot.specification.Specification;

import java.util.function.Function;

public class DepotSteward<LB extends DepotLibrarian<LB,K,F,V,M,R,G>,K extends DepotKey<LB,K,F,V,M,R,G>,F extends Depot<LB,K,F,V,M,R,G>,V extends DepotView<LB,K,F,V,M,R,G>,M extends DepotModel<LB,K,F,V,M,R,G>,R extends DepotReference<LB,K,F,V,M,R,G>,G extends DepotSteward<LB,K,F,V,M,R,G>> extends AddressedSteward<DepotScheme,DepotLibraryKey,DepotLibrary,DepotLibraryView,DepotLibraryModel,DepotLibraryReference, DepotLibrarySteward,DepotPath,DepotCatalogKey,DepotCatalog,DepotCatalogView,DepotCatalogModel,DepotCatalogReference, DepotCatalogSteward,DepotDirectoryLibrarian,DepotDirectoryKey,DepotDirectory,DepotDirectoryView,DepotDirectoryModel,DepotDirectoryReference, DepotDirectorySteward,LB,String,K,F,V,M,R,G> {

    public DepotSteward(Function<R,R> graveDigger, R reference, Class<V> viewClass, Specification specification) {
        super(graveDigger, model, viewClass, specification);
    }
}
