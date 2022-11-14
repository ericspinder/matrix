package dev.inward.matrix.policy;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.Representative;
import dev.inward.matrix.fact.notion.Agent;
import dev.inward.matrix.fact.notion.Notion;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.Operational;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class Practice<BEHAVIOR,N extends Notion<N,I,X,?,?,?>,I extends Identity<I,X>,X extends Context<X>,A extends Agent<N,I,X,A>> extends Policy<BEHAVIOR,N,I,X,A,I,X,Practice<BEHAVIOR,N,I,X,A>> {

    public Practice(@Nonnull A containingAgent) {
        super(containingAgent);
    }

    public Practice(BEHAVIOR BEHAVIOR) {
        super(BEHAVIOR);
    }

}

