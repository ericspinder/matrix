package dev.inward.matrix.datum.fact.notion;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.engine.Memory;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.Operational;
import dev.inward.matrix.datum.fact.Specification;
import dev.inward.matrix.resources.Supplier;
import dev.inward.matrix.engine.Zone;

public class Aspect<Y extends Industry<Y,N,S,I,X,O,A>,N extends Notion<N,I,X,A>,S extends Aspect<Y,N,S,I,X,O,A>,I extends Identity<I,X>,X extends Context<X>,O extends Omnibus<Y,N,S,I,X,O,A>,A extends Agent<N,I,X,A>> extends Operational<Y,N,S,I,X,O,A,N,I,X,A> {

    protected final Memory<Y, N, S, I, X, O, A> notionsInMemory = new Memory();

    public Aspect(Zone zone, Specification<N, I, X> specification, Supplier<Y, N, S, I, X, O, A, N, I, X, A> supplier) {
        super(zone, specification, supplier);
    }
}

