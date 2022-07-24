package dev.inward.matrix.fact.notion.interaction.http;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.matter.Matter;
import dev.inward.matrix.matter.Topic;

import java.time.Instant;
import java.util.UUID;

public class HttpResponse<IA extends Identity<IA,XA>,XA extends Context<XA>> extends Matter<HttpResponse<IA,XA>,IA,XA> {
    public HttpResponse(UUID uuid, IA topicId, Instant createInstant, Topic topic) {
        super(uuid, topicId, createInstant, topic);
    }
}
