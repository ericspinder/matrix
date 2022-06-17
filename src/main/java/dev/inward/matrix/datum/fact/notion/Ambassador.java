package dev.inward.matrix.datum.fact.notion;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Diplomat;
import dev.inward.matrix.datum.fact.notion.concept.*;

import java.lang.ref.ReferenceQueue;
import java.math.BigInteger;

public class Ambassador<Y extends Industry<Y,N,S,I,X,O,A,?,?,?,?,?>,N extends Notion<N,I,X,A>,S extends Aspect<Y,N,S,I,X,O,A>,I extends Identity<I,X>,X extends Context<X>,O extends Omnibus<Y,N,S,I,X,O,A>,A extends Ambassador<Y,N,S,I,X,O,A>> extends Diplomat<Y,N,S,I,X,O,A> {

    public Ambassador(N fact, ReferenceQueue<N> referenceQueue, O omnibus, S aspect) {
        super(fact,referenceQueue,omnibus,aspect);
    }


}
