package dev.inward.matrix.rubric;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.matter.Matter;
import dev.inward.matrix.matter.Topic;

import java.time.Instant;
import java.util.UUID;

public abstract class Rating<I extends Identity<I,X>,X extends Context<X>,M extends Matter<I,X,M>> extends Matter<I,X,M> {

    public Rating(UUID uuid, I topicId, Instant createInstant, Topic topic) {
        super(uuid, topicId, createInstant, topic);
    }
}
