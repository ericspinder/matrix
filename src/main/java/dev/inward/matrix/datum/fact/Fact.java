package dev.inward.matrix.datum.fact;

import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;

import java.io.Serializable;

public abstract class Fact<F extends Fact<F,I,X,R,NI,NX>,I extends Identity<I,X>,X extends Context<X>,R extends Representative<F,I,X,R,NI,NX>,NI extends Identity<NI,NX>,NX extends Context<NX>> extends Datum<F,F,R> implements Comparable<F>, Serializable {

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
}
