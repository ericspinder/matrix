package dev.inward.matrix.rubric;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.matter.RemoteMatter;
import dev.inward.matrix.matter.Subject;

import java.time.Instant;
import java.util.UUID;

public abstract class Confounder<F extends Fact<F,I,X,?>,I extends Identity<I, X>, X extends Context<X>,CORO extends Confounder<F,I,X,CORO>> extends RemoteMatter<F,I,X,CORO> {

    public Confounder(UUID uuid, I topicId, Instant createInstant, Subject subject, F effect) {
        super(uuid, topicId, createInstant, subject, effect);

    }

    public abstract Rating estimate(F effect);


}
