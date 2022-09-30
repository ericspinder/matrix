package dev.inward.matrix.datum.fact.notion;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Bus;
import dev.inward.matrix.datum.fact.notion.concept.Context;

public class Omnibus<Y extends Industry<Y,N,S,I,X,O,A>,N extends Notion<N,I,X,A>,S extends Aspect<Y,N,S,I,X,O,A>,I extends Identity<I,X>,X extends Context<X>,O extends Omnibus<Y,N,S,I,X,O,A>,A extends Agent<N,I,X,A>> extends Bus<Y,N,S,I,X,O,A> {

    public Omnibus(S operational) {
        super(operational);
    }
}
