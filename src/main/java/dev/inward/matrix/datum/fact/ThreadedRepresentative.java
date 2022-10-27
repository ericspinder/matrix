package dev.inward.matrix.datum.fact;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;

public class ThreadedRepresentative<F extends Fact<F,I,X,NI,NX>,I extends Identity<I,X>,X extends Context<X>,R extends Representative<F,I,X,R,NI,NX>,NI extends Identity<NI,NX>,NX extends Context<NX>> extends ThreadLocal<R> {

    @Override
    protected R initialValue() {
        return super.initialValue();
    }

    @Override
    public R get() {
        return super.get();
    }
}
