package dev.inward.matrix.datum.fact;

import dev.inward.matrix.advisor.NotionStartupException;
import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.*;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.operational.Operational;
import dev.inward.matrix.rubric.Envoy;

import java.lang.ref.ReferenceQueue;

public class Resources<Y extends Factory<Y,F,O,I,X,B,P,N,A>,DATUM,D extends Datum<DATUM,D,E>,E extends Envoy<DATUM,D,E,F,I,X,P,N,A>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P,N,A>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P,N,A>,P extends Diplomat<Y,F,O,I,X,B,P,N,A>,N extends Notion<N,I,X,A>,A extends Ambassador<?,N,?,I,X,?,A,?,?>> {

    protected final ReferenceQueue<D> referenceQueue;

    public Resources(ReferenceQueue<D> referenceQueue) {
        this.referenceQueue = getReferenceQueue();
    }
    public Resources() {
        this.referenceQueue = new ReferenceQueue<>();
    }

    public ReferenceQueue<D> getReferenceQueue() {
        return this.referenceQueue;
    }



}
