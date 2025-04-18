/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.depot;

import dev.inward.matrix.file.addressed.Addressed;

public abstract class Depot<K extends DepotKey<K,F,V,M,R,B>,F extends Depot<K,F,V,M,R,B>,V extends DepotView<K,F,V,M,R,B>,M extends DepotModel<K,F,V,M,R,B>,R extends DepotReference<K,F,V,M,R,B>,B extends DepotLibrarian<K,F,V,M,R,B>> extends Addressed<DepotScheme,DepotLibraryKey,DepotLibrary,DepotLibraryView,DepotLibraryModel,DepotLibraryReference, DepotLibraryLibrarian,DepotPath,DepotCatalogKey,DepotCatalog,DepotCatalogView,DepotCatalogModel,DepotCatalogReference, DepotCatalogLibrarian,DepotDirectoryLibrarian,DepotDirectoryKey,DepotDirectory,DepotDirectoryView,DepotDirectoryModel,DepotDirectoryReference, DepotDirectoryLibrarian,String,K,F,V,M,R,B> {

    public Depot(K identity) {
        super(identity);
    }



}
