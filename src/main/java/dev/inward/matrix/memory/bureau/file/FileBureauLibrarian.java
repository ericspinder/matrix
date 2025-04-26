/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.memory.bureau.file;

import dev.inward.matrix.memory.bureau.BureauLibrarian;
import dev.inward.matrix.file.addressed.depot.standard.Standard;

public class FileBureauLibrarian<BD extends FileBureau<BD,BV,BM,BR,BB>,BV extends FileBureauView<BD,BV,BM,BR,BB>,BM extends FileBureauModel<BD,BV,BM,BR,BB>,BR extends FileBureauReference<BD,BV,BM,BR,BB>,BB extends FileBureauLibrarian<BD,BV,BM,BR,BB>> extends BureauLibrarian<BD,BV,BM,BR,BB> {
    public FileBureauLibrarian(Standard standard) {
        super(standard);
    }
}
