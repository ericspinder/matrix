package dev.inward.matrix.rubric;

import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Diplomat;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.Ambassador;
import dev.inward.matrix.datum.fact.notion.concept.Context;

import java.io.Serializable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

public abstract class Envoy<DATUM,D extends Datum<DATUM,D,E>,E extends Envoy<DATUM,D,E,F,I,X,P,N,A>,F extends Fact<F,I,X,P>,I extends Identity<I,X>,X extends Context<X>,P extends Diplomat<?,F,?,I,X,?,P,N, A>,N extends Notion<N,I,X, A>, A extends Ambassador<?,N,?,I,X,?, A,?,?>> extends SoftReference<DATUM> implements Comparable<E>, Serializable {

    public Envoy(DATUM datum, ReferenceQueue<DATUM> referenceQueue) {
        super(datum, referenceQueue);
    }
    public DATUM getDatum() {
        return this.get();
    }

}