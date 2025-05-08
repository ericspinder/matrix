/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.file.addressed.depot.standard.Standard;
import dev.inward.matrix.file.directory.*;

public class DatumLibrarian<D extends Datum<D,V,M,R,L,DF,DK,DV,DM,DR,DL,PATH>,V extends DatumView<D,V,M,R,L,DF,DK,DV,DM,DR,DL,PATH>,M extends DatumModel<D,V,M,R,L,DF,DK,DV,DM,DR,DL,PATH>,R extends DatumReference<D,V,M,R,L,DF,DK,DV,DM,DR,DL,PATH>,L extends DatumLibrarian<D,V,M,R,L,DF,DK,DV,DM,DR,DL,PATH>,DF extends Directory<DF,DK,DV,DM,DR,DL,PATH>,DK extends DirectoryKey<DF,DK,DV,DM,DR,DL,PATH>,DV extends DirectoryView<DF,DK,DV,DM,DR,DL,PATH>,DM extends DirectoryModel<DF,DK,DV,DM,DR,DL,PATH>,DR extends DirectoryReference<DF,DK,DV,DM,DR,DL,PATH>,DL extends DirectoryLibrarian<DF,DK,DV,DM,DR,DL,PATH>,PATH extends Comparable<PATH>> extends Librarian<D,V,M,R,L> {

    public DatumLibrarian(Standard standard) {
        super(standard);
    }
}
