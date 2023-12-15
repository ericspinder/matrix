package dev.inward.matrix.personality;

import dev.inward.matrix.Library;
import dev.inward.matrix.MatrixException;
import dev.inward.matrix.Context;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.fact.matter.Indicia;

import java.security.Permission;
import java.security.PermissionCollection;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.locks.StampedLock;

public class Personality<S extends Scheme<S,L>,L extends Library<S,L>,EXPIRE extends Comparable<EXPIRE>> extends PermissionCollection {

    public static final Personality Aforementioned = new Personality();

    private final StampedLock gate = new StampedLock();
    protected final Vector<Psyche> activePsyches = new Vector<>();
    protected final Vector<Session> offeredSessions = new Vector<>();
    protected Psyche psyche;

    @Override
    public void add(Permission permission) {
        if (permission instanceof Persona) {
            long lock = personaGate.writeLock();
            try {
                this.knownPersonas.add((Persona) permission);

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
        if (permission instanceof Persona) {
            return ((Persona)knownPermission).persona == ((Persona)permission).persona;
                if (knownPermission instanceof Psyche) {
                    return Arrays.binarySearch(((Psyche)knownPermission).personas,((Persona) permission).persona) >= 0;
                }
                if (knownPermission instanceof Sessio
        }
        if (permission instanceof Psyche) {
            for (Permission knownPermission: knownPermissions) {
                if (knownPermission instanceof  Persona) {
                    return Arrays.compare(((Psyche)knownPermission).personas,((Psyche) permission).personas) >= 0;
                }
                if (knownPermission instanceof Psyche) {

                }
                if (knownPermission instanceof Session) {

                }
            }
            for (char psychePersona: ((Psyche) permission).personas) {
                for (Permission personaRaw: this.personas) {
                    if (((Persona)personaRaw).persona == psychePersona) return true;
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
