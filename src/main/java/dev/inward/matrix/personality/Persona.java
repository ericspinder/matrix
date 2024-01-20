package dev.inward.matrix.personality;

import dev.inward.matrix.Identity;
import dev.inward.matrix.Library;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.authority.Domain;
import dev.inward.matrix.fact.Addressed;
import dev.inward.matrix.fact.datum.User;

import javax.security.auth.Subject;
import java.nio.file.attribute.GroupPrincipal;
import java.nio.file.attribute.UserPrincipal;
import java.security.cert.CertPath;
import java.util.Objects;

public abstract class Persona<S extends Scheme<S,L>,L extends Library<S,L>> extends User<S, L, Identity.Ethereal.Id<S,L>,Persona<S,L>> {

    protected char persona;
    protected String description;
    protected Monitor<CertPath>[] credentialMonitor;

    public Persona(Identity.Ethereal.Id<S,L,P> ego, String description) {
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

}
