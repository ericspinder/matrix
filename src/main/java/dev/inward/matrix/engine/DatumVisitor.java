package dev.inward.matrix.engine;

import dev.inward.matrix.fact.datum.Envoy;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Opcodes;

public abstract class DatumVisitor<DATUM> extends ClassVisitor {

    public DatumVisitor() {
        super(Opcodes.ASM9);
    }

    static {
    }

}
