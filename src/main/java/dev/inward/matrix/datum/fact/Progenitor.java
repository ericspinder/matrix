package dev.inward.matrix.datum.fact;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.Primogenitor;
import dev.inward.matrix.datum.fact.notion.concept.Concept;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Mortal;
import dev.inward.matrix.operational.Operational;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.UUID;

public class Progenitor<Y extends Factory<Y,F,O,I,X,B,P,NP,PP,C,M>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P,NP,PP,C,M>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P,NP,PP,C,M>,P extends Progenitor<Y,F,O,I,X,B,P,NP,PP,C,M>,NP extends Notion<NP,I,X,PP>,PP extends Primogenitor<?,NP,?,I,X,?,PP,C,M>,C extends Concept<C,?,M>,M extends Mortal<?,C,?,?,?,M>> extends SoftReference<F> implements Comparable<P> {

    protected UUID uuid = UUID.randomUUID();
    protected final B bus;
    protected final O operational;

    public Progenitor(F fact, ReferenceQueue<F> referenceQueue,B bus, O operational) {
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
