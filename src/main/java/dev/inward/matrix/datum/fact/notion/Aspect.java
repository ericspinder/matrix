package dev.inward.matrix.datum.fact.notion;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Memory;
import dev.inward.matrix.datum.fact.notion.concept.Concept;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Mortal;
import dev.inward.matrix.operational.Operational;
import dev.inward.matrix.operational.Options;
import dev.inward.matrix.operational.Supplier;

public class Aspect<Y extends Industry<Y,N,S,I,X,O,P,C,M>,N extends Notion<N,I,X,P>,S extends Aspect<Y,N,S,I,X,O,P,C,M>,I extends Identity<I,X>,X extends Context<X>,O extends Omnibus<Y,N,S,I,X,O,P,C,M>,P extends Primogenitor<Y,N,S,I,X,O,P,C,M>,C extends Concept<C,?,M>,M extends Mortal<?,C,?,?,?,M>> extends Operational<Y,N,S,I,X,O,P,C,M> {

    protected final Memory<X,P> notionsInMemory = new Memory();

    public Aspect(Options options, Supplier<Y,N,S,I,X,O,P,N,P> supplier) {
        super(options, supplier);
    }
}
