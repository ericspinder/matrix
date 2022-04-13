package dev.inward.matrix.datum.fact.notion;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Progenitor;
import dev.inward.matrix.datum.fact.notion.concept.Context;

import java.lang.ref.ReferenceQueue;

public class Primogenitor<Y extends Industry<Y,N,S,I,X,O,P>,N extends Notion<N,I,X,P>,S extends Aspect<Y,N,S,I,X,O,P>,I extends Identity<I,X>,X extends Context<X>,O extends Omnibus<N,O>,P extends Primogenitor<Y,N,S,I,X,O,P>> extends Progenitor<Y,N,S,I,X,O,P> {

    public Primogenitor(N fact, ReferenceQueue<N> referenceQueue, O omnibus,S aspect) {
        super(fact,referenceQueue,omnibus,aspect);
    }
}
