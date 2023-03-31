package dev.inward.matrix.policy;

import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.Representative;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.Context;

import javax.annotation.Nonnull;
import java.util.Objects;

/**
 * @param <BEHAVIOR> The object created during initialization
 * @param <CF> Containing Fact's class
 * @param <CO> Containing Fact's operational class
 * @param <CI> Containing Fact's Identity class
 * @param <CX> Containing Fact's Context class
 * @param <CR> Containing Fact's Representative class
 * @param <NI> Containing Notion's Identity
 * @param <NX> Containing Notion's Context
 * @param <P> This class - allows Comparable<P> to work
 */
public abstract class Policy<BEHAVIOR,F extends Fact<F,I,ID,X>,I extends Identity<I,ID,X>,ID extends Comparable<ID>,X extends Context<X>,R extends Representative<F,I,ID,X>,NI extends Identity<NI,NX>,NX extends Context<NX>,P extends Policy<BEHAVIOR,CF,CI,CX,CR,NI,NX,P>> implements Comparable<P> {

    protected final BEHAVIOR behavior;

    public Policy(@Nonnull CR containingFact) {
        this.behavior = this.initDefault(containingFact);
    }

    public Policy(BEHAVIOR BEHAVIOR) {
        this.behavior = BEHAVIOR;
    }

    public BEHAVIOR getBehavior() {
        return this.behavior;
    }

    protected abstract BEHAVIOR initDefault(@Nonnull CR containingFact);

    @Override
    public int compareTo(P that) {
        return this.getClass().getCanonicalName().compareTo(that.getClass().getCanonicalName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return this.getClass().getCanonicalName().compareTo(o.getClass().getCanonicalName()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.getClass().getCanonicalName());
    }

}
