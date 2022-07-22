package dev.inward.matrix.fact.notion;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.Diplomat;
import dev.inward.matrix.fact.notion.concept.*;

import java.lang.ref.ReferenceQueue;

public class Ambassador<Y extends Industry<Y,N,S,I,X,O,A,?,?,?,?,?>,N extends Notion<N,I,X>,S extends Aspect<Y,N,S,I,X,O,A>,I extends Identity<I,X>,X extends Context<X>,O extends Omnibus<Y,N,S,I,X,O,A>,A extends Ambassador<Y,N,S,I,X,O,A>> extends Diplomat<Y,N,S,I,X,O,A> {

    public Ambassador(N fact, ReferenceQueue<N> referenceQueue, O omnibus, S aspect) {
        super(fact,referenceQueue,omnibus,aspect);
    }


}
