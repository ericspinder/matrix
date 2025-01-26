package dev.inward.matrix;

import dev.inward.matrix.personality.Personality;

import java.io.IOException;
import java.nio.file.attribute.AclEntry;

public abstract class Rule extends Personality.Ego {

    public static class Occurrence implements Comparable<Occurrence> {

        @Override
        public int compareTo(Occurrence o) {
            return 0;
        }
    }
    public static class Matter extends dev.inward.matrix.log.Matter<Matter,Occurrence> {

        @Override
        public Dogma userInfo() {
            return null;
        }

        @Override
        public Permit.Notion getAdministration() {
            return null;
        }

        @Override
        public void close() throws IOException {

        }

        @Override
        public int compareTo(Matter o) {
            return 0;
        }
    }

    protected Class<? extends Rule.Matter> matterClass;
    protected AclEntry aclEntry;

    public Rule(Library library, String name, AclEntry aclEntry) {
        super(name);
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
        return null;
    }

    public AclEntry getAclEntry() {
        return aclEntry;
    }
}
