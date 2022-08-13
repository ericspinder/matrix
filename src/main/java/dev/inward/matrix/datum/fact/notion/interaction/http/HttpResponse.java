package dev.inward.matrix.datum.fact.notion.interaction.http;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.intialized.maker.Response;
import dev.inward.matrix.matter.Indicia;

import java.time.Instant;
import java.util.UUID;

public class HttpResponse<IH extends Identity<IH, XH>, XH extends Context<XH>> extends Response<HttpResponse<IH, XH>, IH, XH> {
    public HttpResponse(UUID uuid, IH topicId, Instant createInstant, Indicia indicia) {
        super(uuid, topicId, createInstant, indicia);
    }
}
