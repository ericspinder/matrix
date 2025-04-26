/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.memory;

import dev.inward.matrix.DatumView;
import dev.inward.matrix.View;

import java.nio.file.attribute.FileStoreAttributeView;

public abstract class MemoryView<MD extends Memory<MD,MV,MM,MR,MB>,MV extends MemoryView<MD,MV,MM,MR,MB>,MM extends MemoryModel<MD,MV,MM,MR,MB>,MR extends MemoryReference<MD,MV,MM,MR,MB>,MB extends MemoryLibrarian<MD,MV,MM,MR,MB>> extends DatumView<MD,MV,MM,MR,MB> implements FileStoreAttributeView {

    public MemoryView(String name, MD md, MR reference) {
        super(name, md, reference);
    }
}
