package dev.inward.matrix.operational.induction;

import dev.inward.matrix.clues.Policy;
import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Representative;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.rubric.Envoy;

import javax.annotation.Nonnull;
import java.lang.ref.ReferenceQueue;

public class Resource<DATUM,D extends Datum<DATUM,D,V,I,X>, V extends Envoy<DATUM,D,V,I,X>,F extends Fact<F,I,X,R,IC,XC>,I extends Identity<I,X>,X extends Context<X>,R extends Representative<F,I,X,R,IC,XC>,IC extends Identity<IC,XC>,XC extends Context<XC>> {

    protected final ReferenceQueue<DATUM> referenceQueue;
    protected final Policy[] policies;


    public Resource() {
        this(null,new ReferenceQueue<>());
    }
    public Resource(Policy[] policies) {
        this(policies, new ReferenceQueue<>());
    }
    public Resource(Policy[] policies, @Nonnull ReferenceQueue<DATUM> referenceQueue) {
        this.referenceQueue = referenceQueue;
        this.policies = policies;
    }

    public ReferenceQueue<DATUM> getReferenceQueue() {
        return this.referenceQueue;
    }


}
