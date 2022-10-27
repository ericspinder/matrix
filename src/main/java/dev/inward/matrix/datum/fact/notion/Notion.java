package dev.inward.matrix.datum.fact.notion;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.notion.concept.Context;

public abstract class Notion<N extends Notion<N,I,X>,I extends Identity<I,X>,X extends Context<X>> extends Fact<N,I,X,I,X> {

    public Notion(I id) {
        super(id);
    }

}
