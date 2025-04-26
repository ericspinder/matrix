/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.memory.bureau;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.memory.MemoryModel;

public class BureauModel<BD extends Bureau<BD,BV,BM,BR,BB>,BV extends BureauView<BD,BV,BM,BR,BB>,BM extends BureauModel<BD,BV,BM,BR,BB>,BR extends BureauReference<BD,BV,BM,BR,BB>,BB extends BureauLibrarian<BD,BV,BM,BR,BB>> extends MemoryModel<BD,BV,BM,BR,BB> {
    public BureauModel(Aspect[] labeledAspects) {
        super(labeledAspects);
    }
}
