package dev.inward.matrix;

import dev.inward.matrix.director.library.catalog.Catalog;
import dev.inward.matrix.fact.Addressed;
import dev.inward.matrix.fact.Concept;

import java.nio.file.attribute.AclEntry;
import java.time.Instant;
import java.util.UUID;

public class Administration extends Concept<String,Administration.Pathway,UUID,Administration.Identity,Administration> implements Addressed.Administration {


    public static class Identity extends Concept.Tangible<String,Administration.Pathway,UUID,Administration.Identity,Administration> {

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
        public Administration get() {
            return null;
        }

        @Override
        public int compareTo(Identity o) {
            return 0;
        }
    }
    public static class Pathway extends dev.inward.matrix.Pathway<String,Pathway> {

        public Pathway(Ledger<String, Pathway> ledger, String string) {
            super(ledger,);
        }

        @Override
        public String getPathString() {
            return null;
        }
    }

    protected AclEntry[] aclEntries;

    public Administration(Dogma.Agent owner, Dogma.House house, AclEntry[] aclEntries) {
        this.owner = owner;
        this.house = house;
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
