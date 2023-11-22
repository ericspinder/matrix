package dev.inward.matrix.fact.authoritative.notion;

import dev.inward.matrix.route.Route;
import dev.inward.matrix.Identity;
import dev.inward.matrix.Context;

public class Itinerary<N extends Notion<N,I,X,A>,S extends Aspect<N,S,I,X,O,A,T>,I extends Identity<I,X>,X extends Context<X>,O extends Omnibus<N,S,I,X,O,A,T>,A extends Agent<N,I,X,A>,T extends Itinerary<N,S,I,X,O,A,T>> extends Route<N,I,X,O,A,N,I,X,A,T> {
}
