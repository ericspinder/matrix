package dev.inward.matrix;

import dev.inward.matrix.authority.Domain;
import dev.inward.matrix.concept.matter.messaging.Engagement;
import dev.inward.matrix.fact.Addressed;

import javax.annotation.Nonnull;
import java.nio.file.attribute.*;
import java.security.Principal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Dogma implements Principal, Addressed<Scheme.Dogma, Library.Dogma,String,UUID,Dogma.Ethereal,Dogma> {

    public static class House extends Dogma implements GroupPrincipal {

        protected final Map<Persona, AclEntry[]> personaRightsMap = new ConcurrentHashMap<>();
        public House(Dogma.Ethereal ethereal, Map<Persona,AclEntry[]> personaRightsMap) {
            super(ethereal);
            if (personaRightsMap != null) {
                this.personaRightsMap.putAll(personaRightsMap);
            }
        }

    }
    public static class Agent extends Dogma implements UserPrincipal {

        public final Map<House,AclEntry[]> houseRightsMap = new ConcurrentHashMap<>();
        public Agent(Ethereal ethereal, Map<House,AclEntry[]> houseRightsMap) {
            super(ethereal);
            if (houseRightsMap != null) {
                this.houseRightsMap.putAll(houseRightsMap);
            }
        }

    }
    public abstract static class Persona extends Dogma {

        public Map<Engagement<?,?,?>, Librarian<?,?,?,?>> engagementLibrarianMap;

        public Persona(Ethereal ethereal) {
            super(ethereal);
        }


    }

    protected final Ethereal ethereal;

    public Dogma(Ethereal ethereal) {
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

    public static class Ethereal extends Identity<Scheme.Dogma, Library.Dogma,String,UUID,Ethereal,Dogma> {

        protected final String userName;
        protected final Library.Dogma library;

        public Ethereal(@Nonnull UUID uuid, String userName, @Nonnull Library.Dogma library) {
            super(uuid);
            this.userName = userName;
            this.library = library;
        }

        @Override
        public Scheme.Dogma getScheme() {
            return this.library.scheme;
        }

        @Override
        public Terrene getTerrene() {
            return this.library.scheme.terrene;
        }

        @Override
        public Domain getDomain() {
            return this.library.domain;
        }

        @Override
        public Pathway. getPathway() {
            return Pathway.Dogma.INSTANCE;
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
