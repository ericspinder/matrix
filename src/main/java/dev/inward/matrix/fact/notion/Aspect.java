package dev.inward.matrix.fact.notion;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.engine.Memory;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.Operational;
import dev.inward.matrix.fact.Specification;
import dev.inward.matrix.resources.Supplier;
import dev.inward.matrix.engine.Zone;

public class Aspect<N extends Notion<N,I,X,A>,S extends Aspect<N,S,I,X,O,A,T>,I extends Identity<I,X>,X extends Context<X>,O extends Omnibus<N,S,I,X,O,A,T>,A extends Agent<N,I,X,A>,T extends Itinerary<N,S,I,X,O,A,T>> extends Operational<N,S,I,X,O,A,N,I,X,A,T> {

    protected final Memory<Y, N, S, I, X, O, A> notionsInMemory = new Memory();

    public Aspect(Zone zone, Specification<N, I, X> specification, Supplier<Y, N, S, I, X, O, A, N, I, X, A> supplier) {
        super(zone, specification, supplier);
    }
}

