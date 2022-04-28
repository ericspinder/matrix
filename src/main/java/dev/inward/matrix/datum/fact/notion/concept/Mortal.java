package dev.inward.matrix.datum.fact.notion.concept;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Primogenitor;

import java.lang.ref.ReferenceQueue;

public class Mortal<F extends Fabrication<F,C,E,X,V,M>,C extends Concept<C,X,M>,E extends Effect<F,C,E,X,V,M>,X extends Context.Platform<X>,V extends Volume<F,C,E,X,V,M>,M extends Mortal<F,C,E,X,V,M>> extends Primogenitor<F,C,E,Identity.Ego<X>,X,V,M> {

    public Mortal(C concept, ReferenceQueue<C> referenceQueue, V bus, E operational) {
        super(concept, referenceQueue, bus, operational);
    }
}
