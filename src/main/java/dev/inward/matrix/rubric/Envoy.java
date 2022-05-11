package dev.inward.matrix.rubric;

import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Bus;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.datum.fact.Progenitor;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.Primogenitor;
import dev.inward.matrix.datum.fact.notion.concept.Concept;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Mortal;
import dev.inward.matrix.operational.Operational;

import java.io.Serializable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

public abstract class Envoy<DATUM,D extends Datum<DATUM,D,F,I,X,P,NP,PP,E>,F extends Fact<F,I,X,P>,I extends Identity<I,X>,X extends Context<X>,P extends Progenitor<?,F,?,I,X,?,P,NP,PP,C,M>,NP extends Notion<NP,I,X,PP>,PP extends Primogenitor<?,NP,?,I,X,?,PP,C,M>,C extends Concept<C,?,M>,M extends Mortal<?,C,?,?,?,M>,E extends Envoy<DATUM,D,F,I,X,P,NP,PP,C,M,E>>
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