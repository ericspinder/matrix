package dev.inward.matrix.fact.datum;

import dev.inward.matrix.fact.setting.MagicWord;

import java.security.Permission;

public class Profile extends Permission {

    protected final MagicWord[] magicWords;

    public Profile(String profile, MagicWord[] magicWords) {
        super(profile);
        this.magicWords = magicWords;
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
