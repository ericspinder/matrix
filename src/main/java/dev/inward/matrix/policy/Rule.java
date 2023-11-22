package dev.inward.matrix.policy;

import dev.inward.matrix.Identity;
import dev.inward.matrix.fact.authoritative.notion.Agent;
import dev.inward.matrix.fact.authoritative.notion.Notion;
import dev.inward.matrix.Context;

public abstract class Rule<BEHAVIOR,N extends Notion<N,I,X,A>,I extends Identity<I,X>,X extends Context<X>,A extends Agent<N,I,X,A>,CN extends Notion<CN,CI,CX,CA>,CI extends Identity<CI,CX>,CX extends Context<CX>,CA extends Agent<CN,CI,CX,CA>,R extends Rule<BEHAVIOR,N,I,X,A,CN,CI,CX,CA,R>> extends Practice<BEHAVIOR,N,I,X,A,N,> {

    public Rule(E effect,M mortal) {
        super(effect, mortal);
    }
    public Rule(E effect,M mortal,Identity.Ego ego) {
        super(effect, mortal,ego);
    }

}
