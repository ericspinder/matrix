/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.file.addressed.depot;

import dev.inward.matrix.concept.file.addressed.Addressed;

public abstract class Depot<F extends Depot<F,K,V,M,R,L>,K extends DepotKey<F,K,V,M,R,L>,V extends DepotView<F,K,V,M,R,L>,M extends DepotModel<F,K,V,M,R,L>,R extends DepotReference<F,K,V,M,R,L>,L extends DepotLibrarian<F,K,V,M,R,L>> extends Addressed<F,String,K,V,M,R,L,DepotDirectory,DepotDirectoryKey,DepotDirectoryView,DepotDirectoryModel, DepotDirectoryReference, DepotDirectoryLibrarian,DepotPath> {

    public Depot(K identity) {
        super(identity);
    }



}
