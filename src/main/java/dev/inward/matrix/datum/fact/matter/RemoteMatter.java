package dev.inward.matrix.datum.fact.matter;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.notion.concept.Context;

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
