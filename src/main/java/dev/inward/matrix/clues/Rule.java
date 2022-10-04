package dev.inward.matrix.clues;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Agent;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.concept.Context;

public abstract class Rule<BEHAVIOR,N extends Notion<N,I,X,A>,I extends Identity<I,X>,X extends Context<X>,A extends Agent<N,I,X,A>,CN extends Notion<CN,CI,CX,CA>,CI extends Identity<CI,CX>,CX extends Context<CX>,CA extends Agent<CN,CI,CX,CA>,R extends Rule<BEHAVIOR,N,I,X,A,CN,CI,CX,CA,R>> extends Practice<BEHAVIOR,N,I,X,A,N,> {

    public Rule(E effect,M mortal) {
        super(effect, mortal);
    }
    public Rule(E effect,M mortal,Identity.Ego ego) {
        super(effect, mortal,ego);
    }

}
