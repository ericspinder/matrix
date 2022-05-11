package dev.inward.matrix.datum.fact.notion;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Progenitor;
import dev.inward.matrix.datum.fact.notion.concept.Concept;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Mortal;

import java.lang.ref.ReferenceQueue;
import java.math.BigInteger;

public class Primogenitor<Y extends Industry<Y,N,S,I,X,O,P,C,M>,N extends Notion<N,I,X,P>,S extends Aspect<Y,N,S,I,X,O,P,C,M>,I extends Identity<I,X>,X extends Context<X>,O extends Omnibus<Y,N,S,I,X,O,P,C,M>,P extends Primogenitor<Y,N,S,I,X,O,P,C,M>,C extends Concept<C,?,M>,M extends Mortal<?,C,?,?,?,M>> extends Progenitor<Y,N,S,I,X,O,P,C,M> {

    protected final BigInteger size;

    public Primogenitor(N fact, ReferenceQueue<N> referenceQueue, O omnibus,S aspect,BigInteger initialSize) {
        super(fact,referenceQueue,omnibus,aspect);
        this.size = initialSize;
    }



}
