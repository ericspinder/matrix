/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.concept.file.FileReference;
import dev.inward.matrix.concept.item.datum.administrator.*;
import dev.inward.matrix.user.*;

import java.nio.file.attribute.*;
import java.security.BasicPermission;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public abstract class Permission<K extends AdministratorKey<K,F,V,M,R,B>,F extends Administrator<K,F,V,M,R,B>,V extends AdministratorView<K,F,V,M,R,B>,M extends AdministratorModel<K,F,V,M,R,B>,R extends FileReference,B extends AdministratorClerk<K,F,V,M,R,B>> extends BasicPermission {
    protected final F who;

    public Permission(F who, String path) {
        super(path);
        this.who = who;
    }
    public static class AclPermission extends Permission<AgentKey, Agent, AgentView, AgentModel, AgentReferenceWeak, AgentClerk> {

        protected final AclEntryType aclEntryType;
        protected final List<AclEntryPermission> aclEntryPermissionList;
        protected final List<AclEntryFlag> aclEntryFlagList;

        public AclPermission(Agent who, String path, AclEntryType aclEntryType, List<AclEntryPermission> aclEntryPermissionList, List<AclEntryFlag> aclEntryFlagList) {
            super(who, path);
            this.aclEntryType = aclEntryType;
            this.aclEntryPermissionList = aclEntryPermissionList;
            this.aclEntryFlagList = aclEntryFlagList;
        }

        public AclEntryType getAclEntryType() {
            return aclEntryType;
        }

        public List<AclEntryPermission> getAclEntryPermissionList() {
            return aclEntryPermissionList;
        }

        public List<AclEntryFlag> getAclEntryFlagList() {
            return aclEntryFlagList;
        }

        @Override
        public String getActions() {
            StringJoiner sj = new StringJoiner(",",aclEntryType.toString() + " - ","");
            for (AclEntryPermission aclEntryPermission: aclEntryPermissionList) {
                sj.add(aclEntryPermission.name());
            }
            return sj.toString();
        }
    }
    public static abstract class PosixPermission<K extends AdministratorKey<K,F,V,M,R,B>,F extends Administrator<K,F,V,M,R,B>,V extends AdministratorView<K,F,V,M,R,B>,M extends AdministratorModel<K,F,V,M,R,B>,R extends FileReference,B extends AdministratorClerk<K,F,V,M,R,B>> extends Permission<K,F,V,M,R,B> {

        protected final List<PosixFilePermission> posixFilePermissionList;
        protected abstract List<PosixFilePermission> parse(List<PosixFilePermission> posixFilePermissions);
        public PosixPermission(F who, String path, List<PosixFilePermission> posixFilePermissionList) {
            super(who, path);
            this.posixFilePermissionList = parse(posixFilePermissionList);
        }

        public static class PosixUserPermission extends PosixPermission<AgentKey, Agent, AgentView, AgentModel, AgentReferenceWeak, AgentClerk> {

            public PosixUserPermission(Agent who, String path, List<PosixFilePermission> posixFilePermissionList) {
                super(who, path,posixFilePermissionList);
            }

            @Override
            protected List<PosixFilePermission> parse(List<PosixFilePermission> posixFilePermissions) {
                List<PosixFilePermission> parsed = new ArrayList<>();
                for (PosixFilePermission posixFilePermission: posixFilePermissions) {
                    if (posixFilePermission.name().startsWith("OWNER")) {
                        parsed.add(posixFilePermission);
                    }
                }
                return  parsed;
            }
        }

        public static class PosixGroupPermission extends PosixPermission<HouseKey, House, HouseView, HouseModel, HouseReferenceWeak, HouseClerk> {

            public PosixGroupPermission(House who, String path, List<PosixFilePermission> posixFilePermissionList) {
                super(who, path, posixFilePermissionList);
            }
            @Override
            protected List<PosixFilePermission> parse(List<PosixFilePermission> posixFilePermissions) {
                List<PosixFilePermission> parsed = new ArrayList<>();
                for (PosixFilePermission posixFilePermission: posixFilePermissions) {
                    if (posixFilePermission.name().startsWith("GROUP")) {
                        parsed.add(posixFilePermission);
                    }
                }
                return  parsed;
            }
        }
        public static class PosixOtherPermission extends PosixPermission<AgentKey,Agent,AgentView,AgentModel, AgentReferenceWeak, AgentClerk> {

            public PosixOtherPermission(String path, List<PosixFilePermission> posixFilePermissionList) {
                super(null, path, posixFilePermissionList);
            }

            @Override
            protected List<PosixFilePermission> parse(List<PosixFilePermission> posixFilePermissions) {
                List<PosixFilePermission> parsed = new ArrayList<>();
                for (PosixFilePermission posixFilePermission: posixFilePermissions) {
                    if (posixFilePermission.name().startsWith("OTHERS")) {
                        parsed.add(posixFilePermission);
                    }
                }
                return  parsed;
            }
        }
    }
}
