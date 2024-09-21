package dev.inward.matrix.personality;

import java.security.Permission;

public class Session extends Permission {

    protected final Identity.Gate gate;

    public Session(String name, Identity.Gate gate) {
        super(name);
        this.gate = gate;
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
