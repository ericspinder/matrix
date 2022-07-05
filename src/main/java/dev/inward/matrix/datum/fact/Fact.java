package dev.inward.matrix.datum.fact;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;

import java.io.Serializable;

public abstract class Fact<F extends Fact<F,I,X>,I extends Identity<I,X>,X extends Context<X>> implements Comparable<F>, Serializable, Identity.Addressable<F,I,X> {

    protected final I id;

    public Fact(I id) {
        this.id = id;
    }


    @Override
    public I getId() {
        return this.id;
    }

    @Override
    public int compareTo(F that) {
        return this.id.compareTo(that.getId());
    }

}
