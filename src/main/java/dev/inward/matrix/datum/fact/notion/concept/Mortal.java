package dev.inward.matrix.datum.fact.notion.concept;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Ambassador;

import java.lang.ref.ReferenceQueue;
import java.math.BigInteger;

public class Mortal<F extends Fabrication<F,C,E,X,V,M>,C extends Concept<C,X,M>,E extends Effect<F,C,E,X,V,M>,X extends Context.Platform<X>,V extends Volume<F,C,E,X,V,M>,M extends Mortal<F,C,E,X,V,M>> extends Ambassador<F,C,E,Identity.Ego<X>,X,V,M,C,M> {

    public Mortal(C concept, ReferenceQueue<C> referenceQueue, V bus, E operational, M mortal, BigInteger initialSize) {
        super(concept, referenceQueue, bus, operational, mortal,initialSize);
    }
//    N fact, ReferenceQueue<N> referenceQueue, O omnibus,S aspect,M mortal, BigInteger initialSize
}
