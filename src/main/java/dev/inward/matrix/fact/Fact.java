package dev.inward.matrix.fact;

import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.personality.Personality;

import java.io.Serializable;

public abstract class Fact<F extends Fact<F,I,ID,X>,I extends Identity<I,ID,X>,ID extends Comparable<ID>,X extends Context<X>> implements Comparable<F>, Serializable {

    protected final I identity;

    public Fact(I identity) {
        this.identity = identity;
    }

    public I getIdentity() {
        return this.identity;
    }

    @Override
    public int compareTo(F that) {
        return this.identity.compareTo(that.identity);
    }

    public final I identity() {
        return this.identity;
    }

    public Personality getPersonality() {
        return (Personality) this.getClass().getProtectionDomain().getPermissions();
    }
}
