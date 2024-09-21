package dev.inward.matrix;

import dev.inward.matrix.concept.matter.messaging.Engagement;

import java.nio.file.attribute.*;
import java.security.Principal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Dogma implements Principal {

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
    public abstract static class Persona extends Dogma {

        public Map<Engagement<?,?,?>, Librarian<?,?,?,?>> engagementLibrarianMap;

        public Persona(String name) {
            super(name);
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
