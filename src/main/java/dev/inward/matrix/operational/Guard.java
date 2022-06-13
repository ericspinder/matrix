package dev.inward.matrix.operational;

import java.security.Permission;
import java.security.PermissionCollection;
import java.util.Enumeration;

public class Guard extends PermissionCollection {


    @Override
    public void add(Permission permission) {

    }

    @Override
    public boolean implies(Permission permission) {
        return false;
    }

    @Override
    public Enumeration<Permission> elements() {
        return null;
    }
}
