package dev.inward.matrix.datum.fact.notion;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Bus;
import dev.inward.matrix.datum.fact.notion.concept.Concept;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Mortal;

public class Omnibus<N extends Notion<N,I,X,A>,S extends Aspect<Y,N,S,I,X,O,A>,I extends Identity<I,X>,X extends Context<X>,O extends Omnibus<N,S,I,X,O,A,C,M,Y>,A extends Agent<N,I,X,A>,C extends Concept<C,M>,M extends Mortal<C,M>,Y extends Itinerary<N,I,X,O,A>> extends Bus<N,I,X,O,A,C, Identity.Ego,Context.Demarc,M,Y> {

    public Omnibus(M driver) {
        super(driver);
    }
}
