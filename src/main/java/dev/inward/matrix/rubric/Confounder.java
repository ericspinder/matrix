package dev.inward.matrix.rubric;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Effect;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.matter.RemoteMatter;
import dev.inward.matrix.matter.Subject;

import java.time.Instant;
import java.util.UUID;

public abstract class Confounder<Y extends Factory<Y,E,?,I,X,?,?>,E extends Effect<Y,E,?,I,X,?,?>,I extends Identity<I, X>, X extends Context<X>,CORO extends Confounder<Y,E,I,X,CORO>> extends RemoteMatter<Y,E,I,X,CORO> {

    public Confounder(UUID uuid, I topicId, Instant createInstant, Subject subject, E effect) {
        super(uuid, topicId, createInstant, subject, effect);

    }

    public abstract Rating estimate(E effect);


}
