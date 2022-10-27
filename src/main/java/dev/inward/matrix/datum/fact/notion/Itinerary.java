package dev.inward.matrix.datum.fact.notion;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Router;
import dev.inward.matrix.datum.fact.notion.concept.Context;

public class Itinerary<N extends Notion<N,I,X,A>,S extends Aspect<N,S,I,X,O,A,T>,I extends Identity<I,X>,X extends Context<X>,O extends Omnibus<N,S,I,X,O,A,T>,A extends Agent<N,I,X,A>,T extends Itinerary<N,S,I,X,O,A,T>> extends Router<N,I,X,O,A,N,I,X,A,T> {
}
