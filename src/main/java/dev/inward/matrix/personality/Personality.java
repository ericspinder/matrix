package dev.inward.matrix.personality;

import dev.inward.matrix.*;
import dev.inward.matrix.log.Indicia;

import java.lang.ref.SoftReference;
import java.nio.file.attribute.AclEntry;
import java.nio.file.attribute.AclEntryPermission;
import java.nio.file.attribute.AclEntryType;
import java.security.Permission;
import java.security.PermissionCollection;
import java.util.*;
import java.util.concurrent.locks.StampedLock;

public class Personality extends PermissionCollection {

    public abstract static class Ego extends Permission {

        protected final SoftReference<Personality> personality;
        public Ego(Personality personality, String name) {
            super(name);
            this.personality = new SoftReference<>(personality);
        }
        @Override
        public final boolean implies(Permission that) {
            if (that instanceof Ego) {
                if (that instanceof Psyche && this instanceof Rule) {
                    return this.process((Psyche) that,(Rule)this);
                }
                if (that instanceof Rule && this instanceof Psyche) {
                    return this.process((Psyche)this,(Rule)that);
                }
                if (that instanceof Psyche && this instanceof Psyche) {
                    return that.getName().equals(this.getName());
                }
                if (that instanceof Rule && this instanceof Rule) {
                    return that.getName().equals(this.getName());
                }
            }
            return false;
        }
        public final boolean process(Psyche psyche, Rule rule) {
            AclEntry ruleEntry = rule.getAclEntry();
            List<AclEntryPermission>
            if (Arrays.stream(psyche.agents).anyMatch(k -> k.equals(ruleEntry.principal()))) {
                if (ruleEntry.type().equals(AclEntryType.ALLOW)) {
                    for (AclEntryPermission rulePermission : ruleEntry.permissions()) {
                        for (AclEntryPermission psychePermission: psyche.entryPermissionCountMap.keySet()) {

                        }
                    }
                }
                if (ruleEntry.type().equals(AclEntryType.ALARM)) {

                }
                if (ruleEntry.type().equals(AclEntryType.AUDIT)) {

                }
                if (ruleEntry.type().equals(AclEntryType.DENY)) {

                }
            };
        }
    }

    private final StampedLock gate = new StampedLock();
    protected final Map<Psyche,AclEntryType[]> activePsyches = new WeakHashMap<>();

    public final void add(Psyche psyche, AclEntryType aclEntryType) {
        long write = gate.writeLock();
        List<AclEntryType> aclEntryTypeList = new ArrayList<>();
        try {
            if (!this.activePsyches.containsKey(psyche)) {
                this.activePsyches.put(psyche, new AclEntryType[] {aclEntryType});
                return;
            }
            AclEntryType[] oldTypes = this.activePsyches.get(psyche);
            for (AclEntryType oldType: oldTypes) {
                if (!((oldType.equals(AclEntryType.ALLOW) && aclEntryType.equals(AclEntryType.DENY)) || (oldType.equals(AclEntryType.DENY) && aclEntryType.equals(AclEntryType.ALLOW)))) {
                    aclEntryTypeList.add();
                }
            }
            AclEntryType[] newTypes = Arrays.copyOf(oldTypes, oldTypes.length + 1);
            newTypes[oldTypes.length] = aclEntryType;
            activePsyches.put(psyche, newTypes);

        }
        finally {
            gate.unlockWrite(write);
        }
    }

    @Override
    public void add(Permission permission) {
        if (permission instanceof Dogma.Persona) {
            long lock = personaGate.writeLock();
            try {
                this.knownPersonas.add((Dogma.Persona) permission);

                return;
            }
            finally {
                personaGate.unlockWrite(lock);
            }
        }
        if (permission instanceof Psyche) {
            this.activePsyches.add((Psyche)permission);
            return;
        }
        if (permission instanceof Session) {
            this.offeredSessions.add((Session)permission);
            return;
        }
        throw new MatrixException(MatrixException.Type.ClassCastException,this.getClass(), Indicia.Focus.Assembly, Indicia.Severity.Critical,new Exception("Must be a Persona, Psyche or Session"));
    }

    /**
     * A Persona will return true if it's persona char value matches of the known personas; false otherwise
     * A Psyche will return true if it's
     * @param permission
     * @return
     * @throws SecurityException
     */
    @Override
    public boolean implies(Permission permission) {
        if (permission instanceof Dogma.Persona) {
            return ((Dogma.Persona)knownPermission).persona == ((Dogma.Persona)permission).persona;
                if (knownPermission instanceof Psyche) {
                    return Arrays.binarySearch(((Psyche)knownPermission).personas,((Dogma.Persona) permission).persona) >= 0;
                }
                if (knownPermission instanceof Sessio
        }
        if (permission instanceof Psyche) {
            for (Permission knownPermission: knownPermissions) {
                if (knownPermission instanceof Dogma.Persona) {
                    return Arrays.compare(((Psyche)knownPermission).personas,((Psyche) permission).personas) >= 0;
                }
                if (knownPermission instanceof Psyche) {

                }
                if (knownPermission instanceof Session) {

                }
            }
            for (char psychePersona: ((Psyche) permission).personas) {
                for (Permission personaRaw: this.personas) {
                    if (((Dogma.Persona)personaRaw).persona == psychePersona) return true;
                }
            }
            return false;
        }
        return personas.
    }

    @Override
    public Enumeration<Permission> elements() {
        return this.personas.elements();
    }

}
