/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed;

import dev.inward.matrix.file.*;
import dev.inward.matrix.file.addressed.depot.specification.Specification;
import dev.inward.matrix.file.addressed.depot.standard.Standard;
import dev.inward.matrix.file.directory.*;

public class AddressedLibrarian<F extends Addressed<F,ID,K,V,M,R,L,DF,DK,DV,DM,DR,DL,PATH>,ID extends Comparable<ID>,K extends AddressedKey<F,ID,K,V,M,R,L,DF,DK,DV,DM,DR,DL,PATH>,V extends AddressedView<F,ID,K,V,M,R,L,DF,DK,DV,DM,DR,DL,PATH>,M extends AddressedModel<F,ID,K,V,M,R,L,DF,DK,DV,DM,DR,DL,PATH>,R extends AddressedReference<F,ID,K,V,M,R,L,DF,DK,DV,DM,DR,DL,PATH>,L extends AddressedLibrarian<F,ID,K,V,M,R,L,DF,DK,DV,DM,DR,DL,PATH>,DF extends Directory<DF,DK,DV,DM,DR,DL,PATH>,DK extends DirectoryKey<DF,DK,DV,DM,DR,DL,PATH>,DV extends DirectoryView<DF,DK,DV,DM,DR,DL,PATH>,DM extends DirectoryModel<DF,DK,DV,DM,DR,DL,PATH>,DR extends DirectoryReference<DF,DK,DV,DM,DR,DL,PATH>,DL extends DirectoryLibrarian<DF,DK,DV,DM,DR,DL,PATH>,PATH extends Comparable<PATH>> extends FileLibrarian<F,K,V,M,R,L> {

    protected final Specification specification;


    public AddressedLibrarian(Standard standard,Specification specification) {
        super(standard);
        this.specification = specification;
    }
}
