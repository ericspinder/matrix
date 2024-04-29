package dev.inward.matrix;

import dev.inward.matrix.authority.Domain;
import dev.inward.matrix.authority.dns.Terrene;
import dev.inward.matrix.concept.matter.messaging.Engagement;
import dev.inward.matrix.fact.Addressed;
import dev.inward.matrix.fact.session.Session;

import javax.annotation.Nonnull;
import javax.security.auth.Subject;
import java.nio.file.attribute.*;
import java.security.Permission;
import java.security.Principal;
import java.security.cert.CertPath;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.StampedLock;

public abstract class Dogma<S extends Scheme<S,L>,L extends Library<S,L>> implements Principal, Addressed<S,L,String,UUID,Dogma.Ethereal<S,L>,Dogma<S,L>> {
    public static class Anonymous<S extends Scheme<S,L>,L extends Library<S,L>> extends Dogma<S,L> {

        public Anonymous(Ethereal<S,L> identity) {
            super(identity);
        }
    }

    public static class House<S extends Scheme<S,L>,L extends Library<S,L>> extends Dogma<S,L> implements GroupPrincipal {

        protected final Map<Persona<S,L>, AclEntry[]> personaRightsMap = new ConcurrentHashMap<>();
        public House(Dogma.Ethereal<S, L> ethereal, Map<Persona<S,L>,AclEntry[]> personaRightsMap) {
            super(ethereal);
            if (personaRightsMap != null) {
                this.personaRightsMap.putAll(personaRightsMap);
            }
        }

    }
    public static class Agent<S extends Scheme<S,L>,L extends Library<S,L>> extends Dogma<S,L> implements UserPrincipal {

        public final Map<House<S,L>,AclEntry[]> houseRightsMap = new ConcurrentHashMap<>();
        public Agent(Ethereal<S, L> ethereal, Map<House<S,L>,AclEntry[]> houseRightsMap) {
            super(ethereal);
            if (houseRightsMap != null) {
                this.houseRightsMap.putAll(houseRightsMap);
            }
        }

    }
    public abstract static class Persona<S extends Scheme<S,L>,L extends Library<S,L>> extends Dogma<S,L> {

        public Map<Engagement<S,L,>>

        public Persona(Ethereal<S,L> ethereal) {
            super(ethereal);
        }

        public CertPath[] getCertPaths() {
            long readLock = gate.readLock();
            try {
                return Arrays.copyOf(certPaths,certPaths.length);
            }
            finally {
                gate.unlockRead(readLock);
            }
        }

        public char getPersona() {
            return persona;
        }

        public String[] getHints() {
            return hints;
        }

        public void setHints(String[] hints) {
            this.hints = hints;
        }
    }

    protected final Ethereal<S,L> ethereal;

    public Dogma(Ethereal<S,L> ethereal) {
        super(ethereal.toString());
        this.ethereal = ethereal;
    }

    @Override
    public final Ethereal<S,L> getIdentity() {
        return ethereal;
    }

    @Override
    public String getName() {
        return ethereal.toString();
    }

    @Override
    public int compareTo(Dogma<S, L> that) {
        return this.ethereal.compareTo(that.ethereal);
    }
    public static class UserPathway<S extends Scheme<S,L>,L extends Library<S,L>> extends Pathway<S,L,String,UserPathway<S,L>> {

        protected final L library;
        protected UserPathway(String s,L library) {
            super(s);
            this.library = library;

        }

        @Override
        public L getLibrary() {
            return this.library;
        }

        @Override
        public int compareTo(UserPathway<S,L> that) {
            int isZero = this.library.compareTo(that.library);
            if (isZero == 0) {
                return this.path.compareTo(that.path);
            }
            return isZero;
        }

    }

    public static class Ethereal<S extends Scheme<S,L>,L extends Library<S,L>> extends Identity<S,L,String,UUID,Ethereal<S,L>,Dogma<S,L>> {

        protected final String userName;
        protected final L library;

        public Ethereal(@Nonnull UUID uuid, String userName, @Nonnull L library) {
            super(uuid);
            this.userName = userName;
            this.library = library;
        }

        @Override
        public S getScheme() {
            return this.library.scheme;
        }

        @Override
        public Terrene getTerrene() {
            return this.library.terrene;
        }

        @Override
        public Domain getDomain() {
            return this.library.domain;
        }

        @Override
        public Pathway.UserPathway getPathway() {
            return Pathway.UserPathway.INSTANCE;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(library.scheme.scheme).append(library.terrene.getSchema()).append(this.id.toString()).append('@').append(library.domain);
            return  stringBuilder.toString();
        }

        @Override
        public int compareTo(Ethereal<S, L> that) {
            return 0;
        }
    }
}
