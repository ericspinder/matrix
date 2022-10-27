package dev.inward.matrix.datum.fact;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.Envoy;

import java.lang.ref.ReferenceQueue;

public abstract class Representative<F extends Fact<F,I,X,NI,NX>,I extends Identity<I,X>,X extends Context<X>,R extends Representative<F,I,X,R,NI,NX>,NI extends Identity<NI, NX>,NX extends Context<NX>> extends Envoy<F,R> {

    protected final NI containerId;

    public Representative(F f, NI containerId, ReferenceQueue<F> referenceQueue) {
        super(f, referenceQueue);
        this.containerId = containerId;
    }
    public NI getContainerId() {
        return this.containerId;
    }
}
