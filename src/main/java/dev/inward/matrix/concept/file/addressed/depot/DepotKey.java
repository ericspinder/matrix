/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.file.addressed.depot;

import dev.inward.matrix.concept.file.addressed.AddressedKey;

import java.net.URI;

public abstract class DepotKey<F extends Depot<F,K,V,M,R,L>,K extends DepotKey<F,K,V,M,R,L>,V extends DepotView<F,K,V,M,R,L>,M extends DepotModel<F,K,V,M,R,L>,R extends DepotReference<F,K,V,M,R,L>,L extends DepotLibrarian<F,K,V,M,R,L>> extends AddressedKey<F,String,K,V,M,R,L,DepotDirectory,DepotDirectoryKey,DepotDirectoryView,DepotDirectoryModel, DepotDirectoryReference, DepotDirectoryLibrarian,DepotPath> {


    protected DepotKey(URI uri, String s, DepotDirectoryKey directoryKey) {
        super(uri, s, directoryKey);
    }

    public abstract static class Builder<F extends Depot<F,K,V,M,R,L>,K extends DepotKey<F,K,V,M,R,L>,V extends DepotView<F,K,V,M,R,L>,M extends DepotModel<F,K,V,M,R,L>,R extends DepotReference<F,K,V,M,R,L>,L extends DepotLibrarian<F,K,V,M,R,L>> extends AddressedKey.Builder<F,String,K,V,M,R,L,DepotDirectory,DepotDirectoryKey,DepotDirectoryView,DepotDirectoryModel, DepotDirectoryReference, DepotDirectoryLibrarian,DepotPath> {

    }

}
