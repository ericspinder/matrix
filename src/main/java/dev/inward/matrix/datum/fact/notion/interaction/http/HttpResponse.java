package dev.inward.matrix.datum.fact.notion.interaction.http;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.matter.maker.Response;
import dev.inward.matrix.matter.Indicia;

import java.time.Instant;
import java.util.UUID;

public class HttpResponse<IH extends Identity<IH, XH>, XH extends Context<XH>> extends Response<HttpPayload,HttpResponse<IH, XH>, IH, XH> {

    public HttpResponse(UUID uuid, IH topicId, Instant createInstant, Indicia indicia, HttpPayload payload) {
        super(uuid, topicId, createInstant, indicia, payload);
    }
}
