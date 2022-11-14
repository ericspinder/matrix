package dev.inward.matrix.fact.notion.interaction.http;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.matter.messaging.Request;
import dev.inward.matrix.fact.matter.Indicia;

import java.time.Instant;
import java.util.UUID;

public class HttpRequest<IH extends Identity<IH,XH>,XH extends Context<XH>> extends Request<HttpRequest<IH,XH>,IH,XH> {

    public HttpRequest(UUID uuid, IH topicId, Instant createInstant, Indicia indicia) {
        super(uuid, topicId, createInstant, indicia);
    }

}
