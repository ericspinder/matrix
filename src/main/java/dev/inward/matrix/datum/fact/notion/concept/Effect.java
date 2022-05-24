package dev.inward.matrix.datum.fact.notion.concept;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Aspect;
import dev.inward.matrix.operational.Options;
import dev.inward.matrix.operational.Supplier;

public class Effect<F extends Fabrication<F,C,E,X,V,M>,C extends Concept<C,X,M>,E extends Effect<F,C,E,X,V,M>,X extends Context.Platform<X>,V extends Volume<F,C,E,X,V,M>,M extends Mortal<F,C,E,X,V,M>> extends Aspect<F,C,E,Identity.Ego<X>,X,V,M,C,M> {

    public Effect(Options options, Supplier<F,C,E, Identity.Ego<X>,X,V,M,C,M> supplier) {
        super(options,supplier);
    }
}
