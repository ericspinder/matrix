package dev.inward.matrix.personality;

import dev.inward.matrix.Rule;

import java.nio.file.attribute.AclEntry;
import java.nio.file.attribute.UserPrincipal;
import java.security.Permission;
import java.util.Arrays;
import java.util.Objects;

public class Psyche extends Permission {

    protected final String description;
    protected UserPrincipal[] userPrincipals;

    public Psyche(String name, String description,UserPrincipal[] userPrincipals) {
        super(name);
        this.description = description;
        this.userPrincipals = userPrincipals;
    }

    @Override
    public boolean implies(Permission permission) {
        if (permission instanceof Psyche) {
            Psyche that = (Psyche) permission;
            if (that == null) {
                return false;
            }
            return Arrays.equals(this.userPrincipals,that.userPrincipals);
        }
        if (permission instanceof Rule<?,?,?,?>)

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
