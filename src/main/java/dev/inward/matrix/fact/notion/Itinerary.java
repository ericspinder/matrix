package dev.inward.matrix.fact.notion;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.Route;
import dev.inward.matrix.fact.notion.concept.Context;

public class Itinerary<N extends Notion<N,I,X,A>,S extends Aspect<N,S,I,X,O,A,T>,I extends Identity<I,X>,X extends Context<X>,O extends Omnibus<N,S,I,X,O,A,T>,A extends Agent<N,I,X,A>,T extends Itinerary<N,S,I,X,O,A,T>> extends Route<N,I,X,O,A,N,I,X,A,T> {
}
