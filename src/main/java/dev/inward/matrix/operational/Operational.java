package dev.inward.matrix.operational;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.*;

import dev.inward.matrix.fact.notion.concept.Context;

import java.security.ProtectionDomain;

public abstract class Operational<Y extends Factory<Y,F,O,I,X,B,P,?,?,?,?,?>,F extends Fact<F,I,X>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P>,P extends Diplomat<Y,F,O,I,X,B,P>> {

    protected final Supplier<Y,F,O,I,X,B,P,?,?,?,?,?> supplier;
    protected final ProtectionDomain protectionDomain;
    protected final Specification<F,I,X> specification;

    public Operational(Specification specification, Supplier<Y,F,O,I,X,B,P,?,?,?,?,?> supplier, ProtectionDomain protectionDomain) {
        this.specification = specification;
        this.supplier = supplier;
        this.protectionDomain = protectionDomain;
    }

    public Supplier<Y,F,O,I,X,B,P,?,?,?,?,?> supplier() {
        return this.supplier;
    }

    public ProtectionDomain protectionDomain() {
        return this.protectionDomain;
    }

    public Specification specification() {
        return this.specification;
    }


}
