package dev.inward.matrix.fact.matter;

import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.Context;
import dev.inward.matrix.fact.authoritative.Reachable;
import dev.inward.matrix.phenomenon.producer.communications.ThreadedConcept;

import java.io.Serializable;
import java.time.Instant;

public abstract class Matter<M extends Matter<M,I,ID,X>,I extends Identity<I,ID,X>,ID extends Comparable<ID>,X extends Context<X>> extends Fact<M,I,ID,X> implements Serializable {

    protected final Reachable reachable;
    protected final I containerId;
    protected final Indicia indicia;
    protected final ThreadedConcept threadedConcept = ThreadedConcept.Instance;
    protected final Instant modificationInstant;

    public Matter(I containerId,ID id, Indicia indicia,Instant modificationInstant) {
        super(containerId,id);
        this.containerId = containerId;
        this.indicia = indicia;
        this.modificationInstant = modificationInstant;
        this.settled = this.defaultSettled();
    }

    public final I getContainerId() {
        return this.containerId;
    }
    public final Instant getModificationInstant() {
        return this.modificationInstant;
    }
    public final Indicia getIndica() {
        return indicia;
    }
    protected final boolean isSettled() {
        return this.settled;
    }
    public boolean defaultSettled() {
        return false;
    }

}
