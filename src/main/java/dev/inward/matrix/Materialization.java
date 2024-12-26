package dev.inward.matrix;

import java.util.Map;
import java.util.UUID;

public class Materialization implements Addressed<String, Materialization.Index,UUID,Materialization.Identity,Materialization> {

    public static class Identity implements Addressed.Identity<String, Index,UUID,Identity, Materialization> {

        protected final UUID uuid;

        public Identity(UUID uuid) {
            this.uuid = uuid;
        }
        @Override
        public UUID getId() {
            return uuid;
        }

        @Override
        public String getPath() {
            return null;
        }

        @Override
        public Materialization get() {
            return null;
        }

        @Override
        public int compareTo(Identity o) {
            return 0;
        }
    }
    public static class Index implements Addressed.Index<String, Index> {

        @Override
        public Permit getAdministration() {
            return null;
        }

        @Override
        public Ledger<String, Index> getLedger() {
            return null;
        }

        @Override
        public String getPath() {
            return null;
        }

        @Override
        public Map<Addressed<String, Index, ?, ?, ?>, ?> getDirectory() {
            return null;
        }

        @Override
        public int compareTo(Index o) {
            return 0;
        }
    }

    @Override
    public Dogma userInfo() {
        return null;
    }

    @Override
    public Identity getIdentity() {
        return null;
    }

    @Override
    public Index getDirectory() {
        return null;
    }

    @Override
    public int compareTo(Materialization o) {
        return 0;
    }
}
