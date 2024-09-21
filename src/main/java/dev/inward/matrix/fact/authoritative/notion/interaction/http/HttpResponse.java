package dev.inward.matrix.fact.authoritative.notion.interaction.http;

import dev.inward.matrix.concept.matter.Indicia;
import dev.inward.matrix.concept.matter.messaging.Response;
import dev.inward.matrix.Context;

import java.time.Instant;
import java.util.UUID;

public class HttpResponse<IH extends Identity<IH, XH>, XH extends Context<XH>> extends Response<HttpPayload,HttpResponse<IH, XH>, IH, XH> {

    public HttpResponse(UUID uuid, IH topicId, Instant createInstant, Indicia indicia, HttpPayload payload) {
        super(uuid, topicId, createInstant, indicia, payload);
    }
}
