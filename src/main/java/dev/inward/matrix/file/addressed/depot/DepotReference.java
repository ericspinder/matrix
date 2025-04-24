/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.depot;

import dev.inward.matrix.file.addressed.Addressed;
import dev.inward.matrix.file.addressed.AddressedLibrarian;
import dev.inward.matrix.file.addressed.AddressedReference;

public class DepotReference<K extends DepotKey<K,F,V,M,R,B>,F extends Depot<K,F,V,M,R,B>,V extends DepotView<K,F,V,M,R,B>,M extends DepotModel<K,F,V,M,R,B>,R extends DepotReference<K,F,V,M,R,B>,B extends DepotLibrarian<K,F,V,M,R,B>> extends AddressedReference<DepotScheme,DepotLibrary,DepotLibraryView,DepotLibraryModel,DepotLibraryReference, DepotLibraryLibrarian,DepotPath,DepotCatalog,DepotCatalogView,DepotCatalogModel,DepotCatalogReference,DepotCatalogLibrarian,DepotDirectoryKey,DepotDirectory,DepotDirectoryView,DepotDirectoryModel,DepotDirectoryReference, DepotDirectoryLibrarian,String,K,F,V,M,R,B> {

    public DepotReference(F referent, B librarian) {
        super(referent, librarian);
    }
}
