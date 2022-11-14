package dev.inward.matrix.fact;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.datum.Standard;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.datum.Envoy;
import dev.inward.matrix.resources.Resources;

import java.util.UUID;

public abstract class Representative<F extends Fact<F,I,X>,I extends Identity<I,X>,X extends Context<X>,R extends Representative<F,I,X,R,NI,NX,C>,NI extends Identity<NI, NX>,NX extends Context<NX>> extends Envoy<F,R> {

    protected final NI containerId;
    protected final Standard<F> standard;

    public Representative(F f, NI containerId, Resources<F,?,I,X,?,?,?,?,?,?,?> referenceQueue, UUID uuid, Standard<F> standard) {
        super(f, referenceQueue,uuid);
        this.standard = standard;
        this.containerId = containerId;
    }
    public NI getContainerId() {
        return this.containerId;
    }

}
