/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.depot;

import dev.inward.matrix.file.addressed.AddressedKey;

import java.net.URI;

public abstract class DepotKey<K extends DepotKey<K,F,V,M,R,B>,F extends Depot<K,F,V,M,R,B>,V extends DepotView<K,F,V,M,R,B>,M extends DepotModel<K,F,V,M,R,B>,R extends DepotReference<K,F,V,M,R,B>,B extends DepotLibrarian<K,F,V,M,R,B>> extends AddressedKey<DepotScheme,DepotLibrary,DepotLibraryView,DepotLibraryModel,DepotLibraryReference, DepotLibraryLibrarian,DepotPath,DepotCatalog,DepotCatalogView,DepotCatalogModel,DepotCatalogReference,DepotCatalogLibrarian,DepotDirectoryKey,DepotDirectory,DepotDirectoryView,DepotDirectoryModel,DepotDirectoryReference, DepotDirectoryLibrarian,String,K,F,V,M,R,B> {


    protected DepotKey(URI uri, String s, DepotDirectoryKey directoryKey) {
        super(uri, s, directoryKey);
    }

    public abstract static class Builder<K extends DepotKey<K,F,V,M,R,B>,F extends Depot<K,F,V,M,R,B>,V extends DepotView<K,F,V,M,R,B>,M extends DepotModel<K,F,V,M,R,B>,R extends DepotReference<K,F,V,M,R,B>,B extends DepotLibrarian<K,F,V,M,R,B>> extends AddressedKey.Builder<DepotScheme,DepotLibrary,DepotLibraryView,DepotLibraryModel,DepotLibraryReference, DepotLibraryLibrarian,DepotPath,DepotCatalog,DepotCatalogView,DepotCatalogModel,DepotCatalogReference,DepotCatalogLibrarian,DepotDirectoryKey,DepotDirectory,DepotDirectoryView,DepotDirectoryModel,DepotDirectoryReference, DepotDirectoryLibrarian,String,K,F,V,M,R,B> {

    }

}
