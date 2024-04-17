package dev.inward.matrix.personality;

import dev.inward.matrix.Dogma;

import java.security.Permission;
import java.util.Arrays;
import java.util.Objects;

public class Personas extends Permission {

    protected final char[] personas;

    public Personas(String name, char[] personas) {
        super(name);
        this.personas = personas;
    }

    @Override
    public boolean implies(Permission permission) {
        if (permission instanceof Dogma.Persona) {
            boolean foundChar;
            for (Character persona : this.personas) {
                foundChar = persona.equals(((Dogma.Persona) permission).persona);
                if (foundChar) return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Psyche)) return false;
        Psyche that = (Psyche) o;
        return Arrays.equals(personas, that.personas);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getName());
        result = 31 * result + Arrays.hashCode(personas);
        return result;
    }

    @Override
    public String getActions() {
        return null;
    }

    @Override
    public void checkGuard(Object object) throws SecurityException {
        this.checkGuard(object);
    }
}
