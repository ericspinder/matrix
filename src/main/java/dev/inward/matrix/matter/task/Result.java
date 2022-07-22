package dev.inward.matrix.matter.task;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.matter.Matter;
import dev.inward.matrix.matter.Topic;

import java.time.Instant;
import java.util.UUID;

public abstract class Result<F extends Fact<F,?,?,I,X,?>,I extends Identity<I,X>,X extends Context<X>,R extends Request<F,I,?,R>,M extends Result<F,I,X,R,M>> extends Matter<I,M> {

    public Result(UUID uuid, I subjectId, Instant createInstant, Topic topic) {
        super(uuid, subjectId, createInstant, topic);
    }
}
