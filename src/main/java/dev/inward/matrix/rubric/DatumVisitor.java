package dev.inward.matrix.rubric;

import dev.inward.matrix.datum.Datum;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Opcodes;

public abstract class DatumVisitor<DATUM,D extends Datum<DATUM,D,?,?,?,?,?>> extends ClassVisitor {

    public DatumVisitor() {
        super(Opcodes.ASM9);
    }

}
