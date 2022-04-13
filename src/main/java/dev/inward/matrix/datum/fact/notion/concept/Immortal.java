package dev.inward.matrix.datum.fact.notion.concept;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Primogenitor;

import java.lang.ref.ReferenceQueue;

public class Immortal<F extends Fabrication<F,C,E,X,V,IM>,C extends Concept<C,X,IM>,E extends Effect<F,C,E,X,V,IM>,X extends Context.Platform<X>,V extends Volume<C,V>,IM extends Immortal<F,C,E,X,V,IM>> extends Primogenitor<F,C,E, Identity.SuperEgo<X>,X,V,IM> {

    public Immortal(C concept, ReferenceQueue<C> referenceQueue, V bus, E operational) {
        super(concept, referenceQueue, bus, operational);
    }
}
