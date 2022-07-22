package dev.inward.matrix.fact.notion.recorder.http;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.matter.Matter;
import dev.inward.matrix.matter.Topic;

import java.time.Instant;
import java.util.UUID;

public class HttpRequest<I extends Identity<I,X>,X extends Context<X>> extends Matter<I,X,HttpRequest<I,X>> {

    public HttpRequest(UUID uuid, I topicId, Instant createInstant, Topic topic) {
        super(uuid, topicId, createInstant, topic);
    }

}
