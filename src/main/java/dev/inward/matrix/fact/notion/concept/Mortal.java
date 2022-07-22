package dev.inward.matrix.fact.notion.concept;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.notion.Ambassador;

import java.lang.ref.ReferenceQueue;

public class Mortal<F extends Fabrication<F,C,E,V,M>,C extends Concept<C,M>,E extends Effect<F,C,E,V,M>,V extends Volume<F,C,E,V,M>,M extends Mortal<F,C,E,V,M>> extends Ambassador<F,C,E,Identity.Ego, Context.JVM,V,M> {

    public Mortal(C fact, ReferenceQueue<C> referenceQueue, V omnibus, E aspect) {
        super(fact, referenceQueue, omnibus, aspect);
    }
}
