package dev.inward.matrix.policy;

import dev.inward.matrix.Identity;
import dev.inward.matrix.fact.authoritative.notion.Agent;
import dev.inward.matrix.fact.authoritative.notion.Notion;
import dev.inward.matrix.Context;

import javax.annotation.Nonnull;

public abstract class Practice<BEHAVIOR,N extends Notion<N,I,X,?,?,?>,I extends Identity<I,X>,X extends Context<X>,A extends Agent<N,I,X,A>> extends Policy<BEHAVIOR,N,I,X,A,I,X,Practice<BEHAVIOR,N,I,X,A>> {

    public Practice(@Nonnull A containingAgent) {
        super(containingAgent);
    }

    public Practice(BEHAVIOR BEHAVIOR) {
        super(BEHAVIOR);
    }

}

