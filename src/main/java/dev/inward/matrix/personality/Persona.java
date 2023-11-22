package dev.inward.matrix.personality;

import dev.inward.matrix.Identity;
import dev.inward.matrix.Library;
import dev.inward.matrix.Profile;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.fact.Concept;
import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.Model;
import dev.inward.matrix.fact.authoritative.notion.Notion;
import dev.inward.matrix.fact.authoritative.notion.house.House;

import javax.security.auth.Subject;
import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.attribute.UserPrincipal;
import java.security.cert.CertPath;
import java.util.Objects;

public class Persona<S extends Scheme<S,L>,L extends Library<S,L>,P extends Persona<S,L,P,H>,H extends House<S,L,H>> extends Concept<S,L,Path,Character, Identity.Tangible.Ego<S,L,P,H>,P> {

    protected String description;
    protected Monitor<CertPath>[] credentialMonitor;

    public Persona(Identity.Tangible.Ego<S,L,P,H> ego, String description) {
        super(ego);
        this.description = description;
    }

    @Override
    public FileSystem getFileSystem() {
        return null;
    }

    @Override
    public Path getParent() {
        return null;
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
}
