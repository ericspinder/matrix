package dev.inward.matrix.operational;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.*;

import dev.inward.matrix.datum.fact.notion.concept.Context;

import java.lang.reflect.ParameterizedType;
import java.security.ProtectionDomain;

public abstract class Operational<Y extends Factory<Y,F,O,I,X,B,P,?,?,?,?,?>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P>,P extends Diplomat<Y,F,O,I,X,B,P>> {

    protected final Supplier<Y,F,O,I,X,B,P,?,?,?,?,?> supplier;
    protected final ProtectionDomain protectionDomain;

    protected final Options options;

    public Operational(Options options,Supplier<Y,F,O,I,X,B,P,?,?,?,?,?> supplier, ProtectionDomain protectionDomain) {
        this.options = options;
        this.supplier = supplier;
        this.protectionDomain = protectionDomain;
    }

    public Supplier<Y,F,O,I,X,B,P,?,?,?,?,?> getSupplier() {
        return this.supplier;
    }

    public ProtectionDomain protectionDomain() {
        return this.protectionDomain;
    }

}
