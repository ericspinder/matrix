/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.personality;

import dev.inward.matrix.file.addressed.info.Agent;
import dev.inward.matrix.file.addressed.info.Persona;

import java.nio.file.attribute.AclEntryPermission;
import java.nio.file.attribute.AclEntryType;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Psyche  {

    protected Persona persona;
    protected Agent[] agents;
    protected static class Experience {
        protected final AclEntryType aclEntryType;
        protected final AtomicInteger count = new AtomicInteger();
        protected Instant lastUpdate = Instant.now();

        public Experience(AclEntryType aclEntryType) {
            this.aclEntryType = aclEntryType;
        }

        public AclEntryType getAclEntryType() {
            return aclEntryType;
        }

        public AtomicInteger getCount() {
            return count;
        }

        public Instant getLastUpdate() {
            return lastUpdate;
        }
        public void resetLastUpdate() {
            this.lastUpdate = Instant.now();
        }
    }

    protected Map<AclEntryPermission, Experience> permissionExperienceMap = new ConcurrentHashMap<>();

    public Psyche(Personality personality, Persona persona, Agent[] agents) {
        super(personality, persona.getName());
        this.persona = persona;
        this.agents = agents;
    }


    @Override
    public boolean equals(Object obj) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String getActions() {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        for (Map.Entry<AclEntryPermission,Experience> entry: permissionExperienceMap.entrySet()) {
            stringBuilder.append(entry.getKey().name());
            if (++count != permissionExperienceMap.size()) {
                stringBuilder.append(',');
            }
        }
        return stringBuilder.toString();
    }
}
