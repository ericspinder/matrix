package dev.inward.matrix.fact;

import dev.inward.matrix.Dogma;
import dev.inward.matrix.Library;
import dev.inward.matrix.Scheme;

public class Visitor<S extends Scheme<S,L,PATH>,L extends Library<S,L,PATH>,PATH extends Comparable<PATH>> {

    protected final Dogma.Persona<S,L,PATH,?,?,?>[] personas;

    public Visitor(final Dogma.Persona[] personas) {

    }
    public final Dogma.Persona[] getPersonas() {
        return personas;
    }
}
