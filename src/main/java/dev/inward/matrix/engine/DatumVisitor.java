/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package dev.inward.matrix.engine;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Opcodes;

public abstract class DatumVisitor<DATUM> extends ClassVisitor {

    public DatumVisitor() {
        super(Opcodes.ASM9);
    }

    static {
    }

}
