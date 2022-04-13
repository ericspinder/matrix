package dev.inward.matrix.matter;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Effect;
import dev.inward.matrix.datum.fact.Factory;

import java.time.Instant;
import java.util.UUID;

public class RemoteMatter<Y extends Factory<Y,E,?,I,X,?,?>,E extends Effect<Y,E,?,I,X,?,?>,I extends Identity<I,X>,X extends Context<X>,RM extends RemoteMatter<Y,E,I,X,RM>> extends Matter<I,X,RM> {

    protected E effect;

    public RemoteMatter(UUID uuid, I topicId, Instant createInstant, Subject subject,E effect) {
        super(uuid, topicId, createInstant, subject);
        this.effect = effect;
    }
    public E getEffect() {
        return this.effect;
    }

}
