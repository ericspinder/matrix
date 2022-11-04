package dev.inward.matrix.datum.fact;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;

public class ThreadedRepresentative<F extends Fact<F,I,X>,I extends Identity<I,X>,X extends Context<X>,NI extends Identity<NI,NX>,NX extends Context<NX>> extends ThreadLocal<Representative<F,I,X,?,NI,NX>> {

    @Override
    protected Representative<F,I,X,?,NI,NX> initialValue() {
        return super.initialValue();
    }

    @Override
    public Representative<F,I,X,?,NI,NX> get() {
        return super.get();
    }

}
