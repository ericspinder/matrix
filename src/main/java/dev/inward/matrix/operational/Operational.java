package dev.inward.matrix.operational;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.*;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.Ambassador;
import dev.inward.matrix.datum.fact.notion.concept.Context;

import java.lang.reflect.ParameterizedType;

public abstract class Operational<Y extends Factory<Y,F,O,I,X,B,P,?,?,?,?,?>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P>,P extends Diplomat<Y,F,O,I,X,B,P>> {

    protected final Supplier<Y,F,O,I,X,B,P> supplier;

    protected final Options options;

    public Operational(Options options,Supplier<Y,F,O,I,X,B,P> supplier) {
        this.options = options;
        this.supplier = supplier;
    }

    public Supplier<Y,F,O,I,X,B,P> getSupplier() {
        return this.supplier;
    }

}
