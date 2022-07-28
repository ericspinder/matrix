package dev.inward.matrix.fact.notion.interaction.http;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.matter.Response;
import dev.inward.matrix.matter.Topic;

import java.time.Instant;
import java.util.UUID;

public class HttpResponse<IH extends Identity<IH, XH>, XH extends Context<XH>> extends Response<HttpResponse<IH, XH>, IH, XH> {
    public HttpResponse(UUID uuid, IH topicId, Instant createInstant, Topic topic) {
        super(uuid, topicId, createInstant, topic);
    }
}
