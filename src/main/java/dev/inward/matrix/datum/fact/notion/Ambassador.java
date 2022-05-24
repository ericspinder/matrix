package dev.inward.matrix.datum.fact.notion;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Diplomat;
import dev.inward.matrix.datum.fact.notion.concept.Concept;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Mortal;

import java.lang.ref.ReferenceQueue;
import java.math.BigInteger;

public class Ambassador<Y extends Industry<Y,N,S,I,X,O,P,C,M>,N extends Notion<N,I,X,P>,S extends Aspect<Y,N,S,I,X,O,P,C,M>,I extends Identity<I,X>,X extends Context<X>,O extends Omnibus<Y,N,S,I,X,O,P,C,M>,P extends Ambassador<Y,N,S,I,X,O,P,C,M>,C extends Concept<C,?,M>,M extends Mortal<?,C,?,?,?,M>> extends Diplomat<Y,N,S,I,X,O,P,N,P> {

    protected final BigInteger size;
    protected final M mortal;
    public Ambassador(N fact, ReferenceQueue<N> referenceQueue, O omnibus, S aspect, M mortal, BigInteger initialSize) {
        super(fact,referenceQueue,omnibus,aspect);
        this.mortal = mortal;
        this.size = initialSize;
    }


}
