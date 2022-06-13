package dev.inward.matrix.datum.fact.notion;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.notion.concept.Context;

public abstract class Notion<N extends Notion<N,I,X,A>,I extends Identity<I,X>,X extends Context<X>,A extends Ambassador<?,N,?,I,X,?,A,?,?>> extends Fact<N,I,X,A> {

    public Notion(I id) {
        super(id);
    }

}
