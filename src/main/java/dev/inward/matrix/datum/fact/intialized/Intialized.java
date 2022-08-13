package dev.inward.matrix.datum.fact.intialized;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.notion.concept.Context;

public class Intialized<P extends Intialized<P,I,X>,I extends Identity<I,X>,X extends Context<X>> extends Fact<P,I,X> {

    public Intialized(I id) {
        super(id);
    }
}

