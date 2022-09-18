package dev.inward.matrix.datum.fact;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.rubric.Envoy;

import java.lang.ref.ReferenceQueue;

public abstract class Representative<F extends Fact<F,I,X,R>,I extends Identity<I,X>,X extends Context<X>,R extends Representative<F,I,X,R>> extends Envoy<F,F,R> {

    public Representative(F f, ReferenceQueue<F> referenceQueue) {
        super(f, referenceQueue);

    }
}
