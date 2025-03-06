/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.file.addressed.info.UserName;
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
    public static class Matter extends dev.inward.matrix.file.addressed.log.Matter<Matter,Occurrence> {

        @Override
        public UserName userInfo() {
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
