package dev.inward.matrix.fact;

import dev.inward.matrix.fact.authoritative.Authoritative;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.personality.Personality;

import java.io.Serializable;

public abstract class Fact<F extends Fact<F,I,ID,X>,I extends Identity<I,ID,X>,ID extends Comparable<ID>,X extends Context<F,I,ID,X>> implements Comparable<F>, Serializable {

    protected final I identity;

    public <A extends Authoritative<A,V,ID ,VERSION,X,?,PX>,V extends Identity.Versioned<V,ID,VERSION,X>,VERSION extends Comparable<VERSION>,PX extends Context<PX>> Fact(PF parent, ID id) {

    }

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
