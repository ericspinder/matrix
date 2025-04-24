/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.depot;

import dev.inward.matrix.file.addressed.AddressedLibrarian;
import dev.inward.matrix.file.addressed.AddressedReference;
import dev.inward.matrix.file.addressed.depot.specification.Specification;
import dev.inward.matrix.file.addressed.depot.standard.Standard;

import java.util.function.Function;

public class DepotLibrarian<K extends DepotKey<K,F,V,M,R,B>,F extends Depot<K,F,V,M,R,B>,V extends DepotView<K,F,V,M,R,B>,M extends DepotModel<K,F,V,M,R,B>,R extends DepotReference<K,F,V,M,R,B>,B extends DepotLibrarian<K,F,V,M,R,B>> extends AddressedLibrarian<DepotScheme,DepotLibrary,DepotLibraryView,DepotLibraryModel,DepotLibraryReference, DepotLibraryLibrarian,DepotPath,DepotCatalog,DepotCatalogView,DepotCatalogModel,DepotCatalogReference,DepotCatalogLibrarian,DepotDirectoryKey,DepotDirectory,DepotDirectoryView,DepotDirectoryModel,DepotDirectoryReference, DepotDirectoryLibrarian,String,K,F,V,M,R,B> {

    public DepotLibrarian(Standard standard, Specification specification) {
        super(standard, specification);
    }
}
