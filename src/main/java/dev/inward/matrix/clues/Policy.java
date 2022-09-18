package dev.inward.matrix.clues;

import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Representative;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.operational.Operational;
import dev.inward.matrix.rubric.Envoy;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Objects;

/**
 * @param <BEHAVIOR> The object created during initialization
 * @param <DATUM> Raw Datum class- could be any class, including Datum
 * @param <D> Datum - The class for DATUM
 * @param <V> Envoy - The soft reference container class for DATUM/Datum
 * @param <CF> Containing Fact's class
 * @param <CO> Containing Fact's operational class
 * @param <CI> Containing Fact's Identity class
 * @param <CX> Containing Fact's Context class
 * @param <CR> Containing Fact's Representative class
 * @param <P> This class - allows Comparable<P> to work
 */
public abstract class Policy<BEHAVIOR,DATUM,D extends Datum<DATUM,D,V,CI,CX>,V extends Envoy<DATUM,D,V,CI,CX>,CF extends Fact<CF,CI,CX,CR,?,?>,CO extends Operational<?,CF,CO,CI,CX,?,?,?,?>,CI extends Identity<CI,CX>,CX extends Context<CX>,CR extends Representative<CF,CI,CX,CR,?,?>,P extends Policy<BEHAVIOR,DATUM,D,V,CF,CO,CI,CX,CR,P>> implements Comparable<P> {

    protected final BEHAVIOR behavior;

    public Policy(@Nonnull CO operational, @Nonnull CR representative, @Nullable CI cid, @Nullable V envoy) {
        this.behavior = this.initDefault(operational, representative, cid, envoy);
    }

    public Policy(BEHAVIOR BEHAVIOR) {
        this.behavior = BEHAVIOR;
    }

    public BEHAVIOR getBehavior() {
        return this.behavior;
    }

    protected abstract BEHAVIOR initDefault(@Nonnull CO operational, @Nonnull CR representative, @Nullable CI cid, @Nullable V envoy);

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
