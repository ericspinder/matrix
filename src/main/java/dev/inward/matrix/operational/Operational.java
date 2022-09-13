package dev.inward.matrix.operational;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.*;

import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.factory.Factory;
import dev.inward.matrix.matter.Matter;
import dev.inward.matrix.operational.induction.Supplier;

public abstract class Operational<Y extends Factory<Y,F,O,I,X,B,R, NI, NX>,F extends Fact<F,I,X,R, NI, NX>,O extends Operational<Y,F,O,I,X,B,R, NI, NX>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,R, NI, NX>,R extends Representative<F,I,X,R, NI, NX>, NI extends Identity<NI, NX>, NX extends Context<NX>> {

    protected final Supplier<Y,F,O,I,X,B,R, NI, NX> supplier;
    protected final Specification<F,I,X> specification;

    public Operational(Specification<F,I,X> specification, Supplier<Y,F,O,I,X,B,R, NI, NX> supplier) {
        this.specification = specification;
        this.supplier = supplier;
    }

    public Supplier<Y,F,O,I,X,B,R, NI, NX> supplier() {
        return this.supplier;
    }

    public Specification<F,I,X> specification() {
        return this.specification;
    }

    public Settle settle(Matter<?,I,X> matter) {

    }
    public void report(Matter<?, NI, NX> matter) {

    }
}
