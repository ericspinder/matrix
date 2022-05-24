package dev.inward.matrix.datum.fact.notion;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Memory;
import dev.inward.matrix.datum.fact.notion.concept.Concept;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Mortal;
import dev.inward.matrix.operational.Operational;
import dev.inward.matrix.operational.Options;
import dev.inward.matrix.operational.Supplier;

public class Aspect<Y extends Industry<Y,N,S,I,X,O,A,C,M>,N extends Notion<N,I,X,A>,S extends Aspect<Y,N,S,I,X,O,A,C,M>,I extends Identity<I,X>,X extends Context<X>,O extends Omnibus<Y,N,S,I,X,O,A,C,M>,A extends Ambassador<Y,N,S,I,X,O,A,C,M>,C extends Concept<C,?,M>,M extends Mortal<?,C,?,?,?,M>> extends Operational<Y,N,S,I,X,O,A,N,A> {

    protected final Memory<Y,N,S,I,X,O,A> notionsInMemory = new Memory();

    public Aspect(Options options, Supplier<Y,N,S,I,X,O,A,N,A> supplier) {
        super(options, supplier);
    }
}
