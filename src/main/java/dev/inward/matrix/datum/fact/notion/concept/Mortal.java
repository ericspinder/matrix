package dev.inward.matrix.datum.fact.notion.concept;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Ambassador;

import javax.security.auth.Subject;
import java.lang.ref.ReferenceQueue;
import java.math.BigInteger;

public class Mortal<F extends Fabrication<F,C,E,V,M>,C extends Concept<C,M>,E extends Effect<F,C,E,V,M>,V extends Volume<F,C,E,V,M>,M extends Mortal<F,C,E,V,M>> extends Ambassador<F,C,E,Identity.Ego, Context.JVM,V,M,C,M> {

    public Mortal(C concept, ReferenceQueue<C> referenceQueue, V bus, E operational, M mortal, BigInteger initialSize, Subject authSubject) {
        super(concept, referenceQueue, bus, operational, mortal,initialSize);
    }
//    N fact, ReferenceQueue<N> referenceQueue, O omnibus,S aspect,M mortal, BigInteger initialSize
}
