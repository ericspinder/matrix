package dev.inward.matrix.operational;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Bus;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.datum.fact.Diplomat;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.Ambassador;
import dev.inward.matrix.datum.fact.notion.concept.Context;

import java.lang.reflect.ParameterizedType;

public abstract class Operational<Y extends Factory<Y,F,O,I,X,B,P,N,A>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P,N,A>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P,N,A>,P extends Diplomat<Y,F,O,I,X,B,P,N,A>,N extends Notion<N,I,X,A>,A extends Ambassador<?,N,?,I,X,?,A,?,?>> {

    protected final Class<F> factClass;
    protected final Supplier<Y,F,O,I,X,B,P,N,A> supplier;

    protected final Options options;

    public Operational(Options options, Supplier<Y,F,O,I,X,B,P,N,A> supplier) {
        this.options = options;
        this.supplier = supplier;
        this.factClass = (Class<F>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    public Supplier getSupplier() {
        return this.supplier;
    }

}
