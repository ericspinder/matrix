package dev.inward.matrix;

import dev.inward.matrix.concept.matter.Matter;

import java.nio.file.attribute.AclEntry;
import java.security.Permission;

public class Rule<S extends Scheme<S, L>, L extends Library<S, L>,M extends Matter<S,L,M,OCCURRENCE>,OCCURRENCE extends Comparable<OCCURRENCE>> extends Permission {

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
