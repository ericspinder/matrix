package dev.inward.matrix.personality;

import dev.inward.matrix.MatrixException;
import dev.inward.matrix.fact.Context;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.authoritative.notion.Notion;
import dev.inward.matrix.fact.matter.Indicia;

import java.security.Permission;
import java.security.PermissionCollection;
import java.util.Enumeration;
import java.util.Vector;

public class Personality<N extends Notion<N,VERSION,V,ID,EXPIRE,G>,VERSION extends Comparable<VERSION>,V extends Identity.Versioned<VERSION,V,ID,EXPIRE,G>,ID extends Comparable<ID>,EXPIRE extends Comparable<EXPIRE>,G extends Context.Governance<EXPIRE,G>> extends PermissionCollection {

    private Vector<Persona> personas = new Vector<>();

    public void add(Persona persona) {
        if (personas.contains(persona)) {

        }
    }
    @Override
    public void add(Permission permission) {
        if (permission instanceof Persona) {
            this.personas.add((Persona)permission);
        }
        throw new MatrixException(MatrixException.Type.ClassCastException,this.getClass(), Indicia.Focus.Assembly, Indicia.Severity.Critical,new Exception("Must be Persona"));
    }

    @Override
    public boolean implies(Permission permission) throws SecurityException {
        if (permission instanceof Persona) {
            return personas.stream().anyMatch(i -> (i.persona == (((Persona) permission).persona)));
        }
        if (permission instanceof Psyche) {
            for (char psychePersona: ((Psyche) permission).psyche) {
                for (Persona persona: this.personas) {
                    if (persona.persona == psychePersona) return true;
                }
            }
        }
        return false;
    }

    @Override
    public Enumeration<Permission> elements() {
        return personas.elements();
    }
}
