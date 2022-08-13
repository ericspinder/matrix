package dev.inward.matrix.datum.fact.notion.concept;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Agent;

import java.lang.ref.ReferenceQueue;

public class Mortal<C extends Concept<C,M>,M extends Mortal<C,M>> extends Agent<C,Identity.Ego,Context.JVM,M> {

    public Mortal(C fact, ReferenceQueue<C> referenceQueue, V omnibus, E aspect) {
        super(fact, referenceQueue, omnibus, aspect);
    }
}
