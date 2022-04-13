package dev.inward.matrix.operational;

import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Bus;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Factory;

import dev.inward.matrix.datum.fact.Progenitor;
import dev.inward.matrix.rubric.Criterion;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.StampedLock;


public abstract class Operational<Y extends Factory<Y,F,O,I,X,B,P>,F extends Fact<F,I,X,P,?,?,?>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<F,B>,P extends Progenitor<Y,F,O,I,X,B,P>> {

    protected StampedLock gate = new StampedLock();

    protected final Map<Class<?>, Criterion<Y,?,F,O,I,X,B,P,?,?,?>[]>  criteriaMap = new HashMap<>();
    protected final Map<Class<? super Datum<?,F,I,X,P,?>>, Supplier<Y,F,O,I,X,B,P>> supplierMap = new HashMap<>();

    protected Options options;

}
