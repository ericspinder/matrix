package dev.inward.matrix.fact.intialized;

import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.Context;

public class Intialized<P extends Intialized<P,I,X>,I extends Identity<I,X>,X extends Context<X>> extends Fact<P,I,X> {

    public Intialized(I id) {
        super(id);
    }
}

