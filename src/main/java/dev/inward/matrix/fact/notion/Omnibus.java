package dev.inward.matrix.fact.notion;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.Bus;
import dev.inward.matrix.fact.notion.concept.Context;

public class Omnibus<N extends Notion<N,I,X,A>,I extends Identity<I,X>,X extends Context<X>,O extends Omnibus<N,I,X,O,A,T>,A extends Agent<N,I,X,A>,T extends Itinerary<N,S,I,X,O,A,T>> extends Bus<N,I,X,O,A,T> {

    public Omnibus(M driver) {
        super(driver);
    }
}
