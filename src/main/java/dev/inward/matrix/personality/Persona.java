package dev.inward.matrix.personality;

import dev.inward.matrix.Identity;
import dev.inward.matrix.Library;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.authority.Domain;
import dev.inward.matrix.fact.Addressed;

import javax.security.auth.Subject;
import java.nio.file.attribute.GroupPrincipal;
import java.nio.file.attribute.UserPrincipal;
import java.security.cert.CertPath;
import java.util.Objects;

public abstract class Persona<S extends Scheme<S,L>,L extends Library<S,L>,P extends Persona<S,L,P>> implements GroupPrincipal, Addressed<S, L, Domain, Character, Identity.Ego<S, L, P>, P>, Comparable<P> {

    protected char persona;
    protected String description;
    protected Monitor<CertPath>[] credentialMonitor;

    public Persona(Identity.Ego<S,L,P> ego, String description) {
        this.description = description;
    }


    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public String getName() {
        return identity.getId();
    }

    @Override
    public boolean implies(Subject subject) {
        return UserPrincipal.super.implies(subject);
    }

    @Override
    public Identity.Ego<S, L, P> getIdentity() {
        return null;
    }

    public char getPersona() {
        return persona;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int compareTo(P that) {
        return this.perso;
    }
}
