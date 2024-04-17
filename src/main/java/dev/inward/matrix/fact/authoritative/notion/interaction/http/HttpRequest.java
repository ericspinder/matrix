package dev.inward.matrix.fact.authoritative.notion.interaction.http;

import dev.inward.matrix.Identity;
import dev.inward.matrix.concept.matter.Indicia;
import dev.inward.matrix.concept.matter.messaging.Request;
import dev.inward.matrix.Context;

import java.time.Instant;
import java.util.UUID;

public class HttpRequest<IH extends Identity<IH,XH>,XH extends Context<XH>> extends Request<HttpRequest<IH,XH>,IH,XH> {

    public HttpRequest(UUID uuid, IH topicId, Instant createInstant, Indicia indicia) {
        super(uuid, topicId, createInstant, indicia);
    }

}
