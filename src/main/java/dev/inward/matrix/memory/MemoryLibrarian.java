/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.memory;

import dev.inward.matrix.DatumLibrarian;
import dev.inward.matrix.Librarian;
import dev.inward.matrix.file.addressed.depot.standard.Standard;

public abstract class MemoryLibrarian<MD extends Memory<MD,MV,MM,MR,MB>,MV extends MemoryView<MD,MV,MM,MR,MB>,MM extends MemoryModel<MD,MV,MM,MR,MB>,MR extends MemoryReference<MD,MV,MM,MR,MB>,MB extends MemoryLibrarian<MD,MV,MM,MR,MB>> extends DatumLibrarian<MD,MV,MM,MR,MB> {
    public MemoryLibrarian(Standard standard) {
        super(standard);
    }
}
