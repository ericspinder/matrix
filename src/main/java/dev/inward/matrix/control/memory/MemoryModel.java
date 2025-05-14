/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.memory;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.DatumModel;
import dev.inward.matrix.control.ControlModel;

public abstract class MemoryModel<MC extends Memory<MC,MV,MM>,MV extends MemoryView<MC,MV,MM>,MM extends MemoryModel<MC,MV,MM>> extends ControlModel<MC,MV,MM> {
    public MemoryModel(Class<MC> memoryClass, Aspect[] labeledAspects) {
        super(memoryClass, labeledAspects);
    }
}
