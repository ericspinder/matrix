package dev.inward.matrix;

import java.nio.file.attribute.AclEntry;
import java.security.Permission;

public class Rule extends Permission {

    protected AclEntry aclEntry;

    public Rule(String name) {
        super(name);
    }

    @Override
    public boolean implies(Permission permission) {
        return false;
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
}
