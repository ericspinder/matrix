/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.depot;

import dev.inward.matrix.file.addressed.AddressedLibrarian;
import dev.inward.matrix.file.addressed.AddressedReference;
import dev.inward.matrix.file.addressed.depot.specification.Specification;
import dev.inward.matrix.file.addressed.depot.standard.Standard;

import java.util.function.Function;

public class DepotLibrarian<F extends Depot<F,K,V,M,R,L>,K extends DepotKey<F,K,V,M,R,L>,V extends DepotView<F,K,V,M,R,L>,M extends DepotModel<F,K,V,M,R,L>,R extends DepotReference<F,K,V,M,R,L>,L extends DepotLibrarian<F,K,V,M,R,L>> extends AddressedLibrarian<F,String,K,V,M,R,L,DepotDirectory,DepotDirectoryKey,DepotDirectoryView,DepotDirectoryModel,DepotDirectoryReference,DepotDirectoryLibrarian,DepotPath> {

    public DepotLibrarian(Standard standard, Specification specification) {
        super(standard, specification);
    }
}
