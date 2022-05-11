package dev.inward.matrix.datum.fact.notion;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.notion.concept.Context;

public abstract class Notion<N extends Notion<N,I,X,P>,I extends Identity<I,X>,X extends Context<X>,P extends Primogenitor<?,N,?,I,X,?,P,?,?>> extends Fact<N,I,X,P> {

    public Notion(I id) {
        super(id);
    }

}
