package dev.inward.matrix.engine;

import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.Factory;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.Context;

public abstract class Zone<Z extends Zone<Z>> {

    private final Purpose purpose;

    public Zone(Purpose purposes) {
        this.purpose = purposes;
    }
    public abstract <F extends Fact<F,I,ID,X>,I extends Identity<I,ID,X>,ID extends Comparable<ID>,X extends Context<X>> Factory<?,F,I,ID,X,?> get();
}
