package dev.inward.matrix.fact.tracked;

import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.Context;

public abstract class Tracked<T extends Tracked<T,VERSION,V,X>,VERSION extends Comparable<VERSION>,V extends Identity.WebPage<?,V,X>,X extends Context<X>> extends Fact<T,V,X> {

    public Tracked(V identity) {
        super(identity);
    }
}