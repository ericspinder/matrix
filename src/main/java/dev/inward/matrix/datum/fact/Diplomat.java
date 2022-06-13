package dev.inward.matrix.datum.fact;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.Ambassador;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.operational.Operational;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.UUID;

public class Diplomat<Y extends Factory<Y,F,O,I,X,B,P>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P>,P extends Diplomat<Y,F,O,I,X,B,P>> extends SoftReference<F> implements Comparable<P> {

    protected UUID uuid = UUID.randomUUID();
    protected final B bus;
    protected final O operational;

    public Diplomat(F fact, ReferenceQueue<F> referenceQueue, B bus, O operational) {
        super(fact,referenceQueue);
        this.bus = bus;
        this.operational = operational;
    }

    public O getOperational() {
        return this.operational;
    }
    public B getBus() {
        return this.bus;
    }

    @Override
    public int compareTo(P that) {
        return this.uuid.compareTo(that.uuid);
    }
}
