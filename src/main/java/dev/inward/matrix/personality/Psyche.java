package dev.inward.matrix.personality;

import dev.inward.matrix.Dogma;
import dev.inward.matrix.Library;
import dev.inward.matrix.Rule;

import java.math.BigInteger;
import java.nio.file.attribute.AclEntry;
import java.nio.file.attribute.AclEntryPermission;
import java.nio.file.attribute.AclEntryType;
import java.nio.file.attribute.UserPrincipal;
import java.security.Permission;
import java.time.Instant;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Psyche extends Personality.Ego {

    protected Dogma.Persona persona;
    protected Dogma.Agent[] agents;
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

    public Psyche(Personality personality, Dogma.Persona persona, Dogma.Agent[] agents) {
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
