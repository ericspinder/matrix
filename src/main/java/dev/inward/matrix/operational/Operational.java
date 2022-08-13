package dev.inward.matrix.operational;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.*;

import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.factory.Factory;
import dev.inward.matrix.matter.Matter;
import dev.inward.matrix.operational.induction.Supplier;

public abstract class Operational<Y extends Factory<Y,F,O,I,X,B,R,IC,XC>,F extends Fact<F,I,X,R,IC,XC>,O extends Operational<Y,F,O,I,X,B,R,IC,XC>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,R,IC,XC>,R extends Representative<F,I,X,R,IC,XC>,IC extends Identity<IC,XC>,XC extends Context<XC>> {

    protected final Supplier<Y,F,O,I,X,B,R,IC,XC> supplier;
    protected final Specification<F,I,X> specification;

    public Operational(Specification<F,I,X> specification, Supplier<Y,F,O,I,X,B,R,IC,XC> supplier) {
        this.specification = specification;
        this.supplier = supplier;
    }

    public Supplier<Y,F,O,I,X,B,R,IC,XC> supplier() {
        return this.supplier;
    }

    public Specification<F,I,X> specification() {
        return this.specification;
    }

    public Settle settle(Matter<?,I,X> matter) {

    }
    public void report(Matter<?,IC,XC> matter) {

    }
}
