/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.depot;

import dev.inward.matrix.file.addressed.AddressedKey;

import java.net.URI;

public abstract class DepotKey<LB extends DepotLibrarian<LB,K,F,V,M,R,G>,K extends DepotKey<LB,K,F,V,M,R,G>,F extends Depot<LB,K,F,V,M,R,G>,V extends DepotView<LB,K,F,V,M,R,G>,M extends DepotModel<LB,K,F,V,M,R,G>,R extends DepotReference<LB,K,F,V,M,R,G>,G extends DepotSteward<LB,K,F,V,M,R,G>> extends AddressedKey<DepotScheme,DepotLibraryKey,DepotLibrary,DepotLibraryView,DepotLibraryModel,DepotLibraryReference, DepotLibrarySteward,DepotPath,DepotCatalogKey,DepotCatalog,DepotCatalogView,DepotCatalogModel,DepotCatalogReference, DepotCatalogSteward,DepotDirectoryLibrarian,DepotDirectoryKey,DepotDirectory,DepotDirectoryView,DepotDirectoryModel,DepotDirectoryReference, DepotDirectorySteward,LB,String,K,F,V,M,R,G> {


    protected DepotKey(URI uri, String s, DepotDirectoryKey directoryKey) {
        super(uri, s, directoryKey);
    }

    public abstract static class Builder<LB extends DepotLibrarian<LB,K,F,V,M,R,G>,K extends DepotKey<LB,K,F,V,M,R,G>,F extends Depot<LB,K,F,V,M,R,G>,V extends DepotView<LB,K,F,V,M,R,G>,M extends DepotModel<LB,K,F,V,M,R,G>,R extends DepotReference<LB,K,F,V,M,R,G>,G extends DepotSteward<LB,K,F,V,M,R,G>> extends AddressedKey.Builder<DepotScheme,DepotLibraryKey,DepotLibrary,DepotLibraryView,DepotLibraryModel,DepotLibraryReference, DepotLibrarySteward,DepotPath,DepotCatalogKey,DepotCatalog,DepotCatalogView,DepotCatalogModel,DepotCatalogReference, DepotCatalogSteward,DepotDirectoryLibrarian,DepotDirectoryKey,DepotDirectory,DepotDirectoryView,DepotDirectoryModel,DepotDirectoryReference, DepotDirectorySteward,LB,String,K,F,V,M,R,G> {

    }

}
