package dev.inward.matrix;

import java.nio.file.attribute.AclEntry;
import java.time.Instant;
import java.util.UUID;

public class Administration extends Concept<String, Index.Data,UUID,Administration.Identity,Administration> {


    public static class Identity extends Concept.Identity<String, Permit.Pathway,UUID, Permit.Identity, Permit> {

        public Identity(UUID uuid) {
            super(uuid);
        }

        @Override
        public UUID getId() {
            return null;
        }

        @Override
        public Instant getPath() {
            return null;
        }

        @Override
        public Permit get() {
            return null;
        }

        @Override
        public int compareTo(Identity o) {
            return 0;
        }
    }

    protected AclEntry[] aclEntries;

    public Administration(Dogma.Agent owner, Dogma.House house, AclEntry[] aclEntries) {
        this.aclEntries = aclEntries;
    }
    public Dogma.Agent getOwner() {
        return owner;
    }
    public AclEntry[] getAclEntries() {
        return aclEntries;
    }

    public void setAclEntries(AclEntry[] aclEntries) {
        this.aclEntries = aclEntries;
    }
}
