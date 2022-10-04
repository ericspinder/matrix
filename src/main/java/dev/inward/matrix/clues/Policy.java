package dev.inward.matrix.clues;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Representative;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.Operational;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
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
public abstract class Policy<BEHAVIOR,CF extends Fact<CF,CI,CX,CR,NI,NX>,CO extends Operational<?,CF,CO,CI,CX,?,CR,?,NI,NX,?>,CI extends Identity<CI,CX>,CX extends Context<CX>,CR extends Representative<CF,CI,CX,CR,NI,NX>,NI extends Identity<NI,NX>,NX extends Context<NX>,P extends Policy<BEHAVIOR,CF,CO,CI,CX,CR,NI,NX,P>> implements Comparable<P> {

    protected final BEHAVIOR behavior;

    public Policy(@Nonnull CO operational, @Nonnull CR representative, @Nullable CI cid, @Nullable NI nid) {
        this.behavior = this.initDefault(operational, representative, cid, nid);
    }

    public Policy(BEHAVIOR BEHAVIOR) {
        this.behavior = BEHAVIOR;
    }

    public BEHAVIOR getBehavior() {
        return this.behavior;
    }

    protected abstract BEHAVIOR initDefault(@Nonnull CO operational, @Nonnull CR representative, @Nullable CI cid, @Nullable NI nid);

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
