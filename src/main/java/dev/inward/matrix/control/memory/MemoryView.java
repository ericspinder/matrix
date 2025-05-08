/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.memory;

import dev.inward.matrix.control.ControlView;

import java.nio.file.attribute.FileStoreAttributeView;

public abstract class MemoryView<MC extends Memory<MC,MV,MM>,MV extends MemoryView<MC,MV,MM>,MM extends MemoryModel<MC,MV,MM>> extends ControlView<MC,MV,MM> implements FileStoreAttributeView {

    public MemoryView(String name, MC memory) {
        super(name, memory);
    }
}
