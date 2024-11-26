package dev.inward.matrix;

import dev.inward.matrix.personality.Psyche;

import javax.security.auth.Subject;
import java.nio.file.attribute.*;
import java.security.Principal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Dogma extends Concept<String,> implements Principal {

    public static class House extends Dogma implements GroupPrincipal {

        protected final Map<Persona, AclEntry[]> personaRightsMap = new ConcurrentHashMap<>();
        public House(String name, Map<Persona,AclEntry[]> personaRightsMap) {
            super(name);
            if (personaRightsMap != null) {
                this.personaRightsMap.putAll(personaRightsMap);
            }
        }

    }
    public static class Agent extends Dogma implements UserPrincipal {

        protected final Map<House, AclEntry[]> houseRightsMap = new ConcurrentHashMap<>();
        public Agent(String name,Map<House,AclEntry[]> houseRightsMap) {
            super(name);
            if (houseRightsMap != null) {
                this.houseRightsMap.putAll(houseRightsMap);
            }
        }

    }

    public static class Persona extends Dogma {

        protected final Map<Agent,;

        public Persona(String name, char[] personas) {
            super(name);
            this.personas = personas;
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
        public boolean implies(Subject subject) {
            return Principal.super.implies(subject);
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
    protected final String name;
    public Dogma(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
