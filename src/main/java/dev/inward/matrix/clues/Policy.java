package dev.inward.matrix.clues;

import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.rubric.Envoy;

import java.util.Objects;

public abstract class Policy<BEHAVIOR,DATUM,D extends Datum<DATUM,D,V,CI,CX>,V extends Envoy<DATUM,D,V,CI,CX>,CI extends Identity<CI,CX>,CX extends Context<CX>, P extends Policy<BEHAVIOR,DATUM,D,V,CI,CX,P>> implements Comparable<P> {

    protected final BEHAVIOR exhibit;

    public Policy(CI id) {
        this.exhibit = this.initDefault(id);
    }

    public Policy(BEHAVIOR BEHAVIOR) {
        this.exhibit = BEHAVIOR;
    }

    public BEHAVIOR getExhibit() {
        return this.exhibit;
    }

    protected abstract BEHAVIOR initDefault(CI containerId);

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
