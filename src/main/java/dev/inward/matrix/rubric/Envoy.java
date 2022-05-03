package dev.inward.matrix.rubric;

import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Bus;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.datum.fact.Progenitor;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.Primogenitor;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.operational.Operational;

import java.io.Serializable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

public abstract class Envoy<Y extends Factory<Y,F,O,I,X,B,P,NP,PP>,DATUM,D extends Datum<DATUM,D,F,I,X,P,NP,PP,E>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P,NP,PP>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P,NP,PP>,P extends Progenitor<Y,F,O,I,X,B,P,NP,PP>,NP extends Notion<NP,I,X,PP>,PP extends Primogenitor<?,NP,?,I,X,?,PP>,E extends Envoy<Y,DATUM,D,F,O,I,X,B,P,NP,PP,E>>
        extends SoftReference<DATUM> implements Comparable<E>, Serializable {
    protected final P progenitor;

    public Envoy(DATUM datum, ReferenceQueue<DATUM> referenceQueue,P progenitor) {
        super(datum, referenceQueue);
        this.progenitor = progenitor;
    }
    public DATUM getDatum() {
        return this.get();
    }
}