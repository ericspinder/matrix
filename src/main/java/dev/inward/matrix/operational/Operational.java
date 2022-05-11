package dev.inward.matrix.operational;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Bus;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.datum.fact.Progenitor;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.Primogenitor;
import dev.inward.matrix.datum.fact.notion.concept.Concept;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Mortal;

import java.lang.reflect.ParameterizedType;

public abstract class Operational<Y extends Factory<Y,F,O,I,X,B,P,NP,PP,C,M>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P,NP,PP,C,M>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P,NP,PP,C,M>,P extends Progenitor<Y,F,O,I,X,B,P,NP,PP,C,M>,NP extends Notion<NP,I,X,PP>,PP extends Primogenitor<?,NP,?,I,X,?,PP,C,M>,C extends Concept<C,?,M>,M extends Mortal<?,C,?,?,?,M>> {

    protected final Class<F> factClass;
    protected final Supplier<Y,F,O,I,X,B,P,NP,PP> supplier;

    protected final Options options;

    public Operational(Options options, Supplier<Y,F,O,I,X,B,P,NP,PP> supplier) {
        this.options = options;
        this.supplier = supplier;
        this.factClass = (Class<F>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    public Supplier getSupplier() {
        return this.supplier;
    }

}
