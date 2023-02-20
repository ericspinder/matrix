package dev.inward.matrix.personality;

import java.security.Permission;
import java.security.PermissionCollection;
import java.util.Enumeration;
import java.util.Vector;

public class Personality extends PermissionCollection {

    private Vector<Permission> psyches = new Vector<>();
    @Override
    public void add(Permission permission) {
        if (permission instanceof Psyche) {
            this.psyches.add((Psyche)permission);
        }
    }

    @Override
    public boolean implies(Permission permission) {
        if (permission instanceof Psyche) {
            return psyches.stream().anyMatch(i -> i.getName().equals(permission.getName()));
        }
        return false;
    }

    @Override
    public Enumeration<Permission> elements() {
        return psyches.elements();
    }
}
