package dev.inward.matrix.domain;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.matter.Matter;
import dev.inward.matrix.matter.Topic;

import java.time.Instant;
import java.util.UUID;

public class Orders<I extends Identity<I,X>,X extends Context<X>> extends Matter<I,X,Orders<I,X>> {

    public Orders(UUID uuid, I topicId, Instant createInstant, Topic topic) {
        super(uuid, topicId, createInstant, topic);
    }
}
