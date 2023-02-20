package dev.inward.matrix.fact.matter;

import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.Context;

import java.time.Instant;
import java.util.UUID;

public class RemoteMatter<E extends Fact<E,I,X,>,I extends Identity<I,X>,X extends Context<X>,RM extends RemoteMatter<E,I,X,RM>> extends Matter<I,X,RM> {

    protected E effect;

    public RemoteMatter(UUID uuid, I topicId, Instant createInstant, Indicia indicia, E effect) {
        super(uuid, topicId, createInstant, indicia);
        this.effect = effect;
    }
    public E getEffect() {
        return this.effect;
    }

}
