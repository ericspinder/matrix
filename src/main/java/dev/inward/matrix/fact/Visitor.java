package dev.inward.matrix.fact;

import dev.inward.matrix.Library;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.personality.Persona;

public class Visitor<S extends Scheme<S,L,PATH>,L extends Library<S,L,PATH>,PATH extends Comparable<PATH>> {

    protected final Persona<S,L,PATH,?,?,?>[] personas;

    public Visitor(final Persona[] personas) {

    }
    public final Persona[] getPersonas() {
        return personas;
    }
}
