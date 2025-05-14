/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.depot;

import dev.inward.matrix.file.addressed.Addressed;
import dev.inward.matrix.file.addressed.AddressedModel;
import dev.inward.matrix.file.addressed.AddressedView;

public class DepotView<F extends Depot<F,K,V,M,R,L>,K extends DepotKey<F,K,V,M,R,L>,V extends DepotView<F,K,V,M,R,L>,M extends DepotModel<F,K,V,M,R,L>,R extends DepotReference<F,K,V,M,R,L>,L extends DepotLibrarian<F,K,V,M,R,L>> extends AddressedView<F,String,K,V,M,R,L,DepotDirectory,DepotDirectoryKey,DepotDirectoryView,DepotDirectoryModel,DepotDirectoryReference,DepotDirectoryLibrarian,DepotPath> {


    public DepotView(String name, F file) {
        super(name, file);
    }
}
