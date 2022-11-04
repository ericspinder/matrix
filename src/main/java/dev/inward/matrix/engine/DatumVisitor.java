package dev.inward.matrix.engine;

import dev.inward.matrix.datum.Envoy;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Opcodes;

public abstract class DatumVisitor<DATUM,D extends Datum<DATUM,D,V>,V extends Envoy<DATUM,D,V>> extends ClassVisitor {

    public DatumVisitor() {
        super(Opcodes.ASM9);
    }

    static {
    }

}
