/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.depot;

import dev.inward.matrix.file.addressed.AddressedReference;

public class DepotReference<LB extends DepotLibrarian<LB,K,F,V,M,R,G>,K extends DepotKey<LB,K,F,V,M,R,G>,F extends Depot<LB,K,F,V,M,R,G>,V extends DepotView<LB,K,F,V,M,R,G>,M extends DepotModel<LB,K,F,V,M,R,G>,R extends DepotReference<LB,K,F,V,M,R,G>,G extends DepotLibrarian<LB,K,F,V,M,R,G>> extends AddressedReference<DepotScheme,DepotLibraryKey,DepotLibrary,DepotLibraryView,DepotLibraryModel,DepotLibraryReference, DepotLibraryLibrarian,DepotPath,DepotCatalogKey,DepotCatalog,DepotCatalogView,DepotCatalogModel,DepotCatalogReference, DepotCatalogLibrarian,DepotDirectoryLibrarian,DepotDirectoryKey,DepotDirectory,DepotDirectoryView,DepotDirectoryModel,DepotDirectoryReference, DepotDirectoryLibrarian,LB,String,K,F,V,M,R,G> {
    public DepotReference(F addressed, G depotGestalt) {
        super(addressed, depotGestalt);
    }
}
