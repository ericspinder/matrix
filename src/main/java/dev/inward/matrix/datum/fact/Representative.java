package dev.inward.matrix.datum.fact;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.rubric.Envoy;

import java.lang.ref.ReferenceQueue;

public class Representative<F extends Fact<F,I,X,R,IC,XC>,I extends Identity<I,X>,X extends Context<X>,R extends Representative<F,I,X,R,IC,XC>,IC extends Identity<IC,XC>,XC extends Context<XC>> extends Envoy<F,F,R,IC,XC> {

    public final IC containerId;

    public Representative(F f, ReferenceQueue<F> referenceQueue, IC containerId) {
        super(f, referenceQueue);
        this.containerId = containerId;
    }
}
