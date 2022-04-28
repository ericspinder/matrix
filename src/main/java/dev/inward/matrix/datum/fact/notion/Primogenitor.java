package dev.inward.matrix.datum.fact.notion;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Progenitor;
import dev.inward.matrix.datum.fact.notion.concept.Context;

import java.lang.ref.ReferenceQueue;
import java.math.BigInteger;

public class Primogenitor<Y extends Industry<Y,N,S,I,X,O,P>,N extends Notion<N,I,X,P>,S extends Aspect<Y,N,S,I,X,O,P>,I extends Identity<I,X>,X extends Context<X>,O extends Omnibus<Y,N,S,I,X,O,P>,P extends Primogenitor<Y,N,S,I,X,O,P>> extends Progenitor<Y,N,S,I,X,O,P,N,P> {

    protected final BigInteger size;

    public Primogenitor(N fact, ReferenceQueue<N> referenceQueue, O omnibus,S aspect,BigInteger initialSize) {
        super(fact,referenceQueue,omnibus,aspect);
        this.size = initialSize;
    }



}
