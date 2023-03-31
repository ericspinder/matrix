package dev.inward.matrix.personality;

import crud.rubric.Blocker;
import dev.inward.matrix.MatrixException;
import dev.inward.matrix.fact.matter.Indicia;

import java.security.Permission;
import java.security.cert.CertPath;
import java.util.Objects;
import java.util.stream.Stream;

public class Persona extends Permission {

    protected char persona;
    protected final String description;

    public Persona(char persona, String name, String description) {
        super(name);
        this.persona = persona;
        this.description = description;
    }

    @Override
    public void checkGuard(Object object) throws Blocker {

        throw new MatrixException(MatrixException.Type.NotImplemented,this.getClass(), Indicia.Focus.Admonitory, Indicia.Severity.Exceptional,null);
    }
    @Override
    public boolean implies(Permission permission) {
        if (permission instanceof  Persona) {
            return this.persona == ((Persona)permission).persona;
        }
        else if(permission instanceof Psyche) {
            return Stream.of(((Psyche)permission).psyche).anyMatch(chars -> chars.equals(this.persona));
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persona)) return false;
        Persona that = (Persona) o;
        return this.persona == that.persona && this.description.equals(that.description) && this.getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public String getActions() {
        return this.description;
    }
    public String getDescription() {
        return this.description;
    }

    public static class Credentialed extends Persona {

        protected final CertPath credential;
        public Credentialed(char persona, String name, String description, CertPath credential) {
            super(persona,name,description);
            this.credential = credential;

        }

        public CertPath getCredential() {
            return credential;
        }
    }

    public char getPersona() {
        return persona;
    }
}
