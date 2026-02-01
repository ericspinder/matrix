/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.concept.fact.addressed.Addressed;
import dev.inward.matrix.item.datum.administrator.UserName;

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
    public UserName userInfo() {
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
