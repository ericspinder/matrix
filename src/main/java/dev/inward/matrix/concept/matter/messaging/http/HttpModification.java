package dev.inward.matrix.concept.matter.messaging.http;

import dev.inward.matrix.concept.matter.Indicia;
import dev.inward.matrix.concept.matter.messaging.Modification;
import dev.inward.matrix.Context;
import dev.inward.matrix.fact.authoritative.notion.interaction.http.HttpRequest;
import dev.inward.matrix.fact.authoritative.notion.interaction.http.HttpResponse;

import java.time.Instant;
import java.util.UUID;

public class HttpModification<IH extends Identity<IH,XH>,XH extends Context<XH>> extends Modification<HttpModification<IH,XH>,HttpPromise<IH,XH>, HttpResponse<IH,XH>, HttpRequest<IH,XH>,IH,XH> {
    public HttpModification(UUID uuid, IH topicId, Instant createInstant, Indicia indicia, HttpPromise<IH,XH> promise) {
        super(uuid, topicId, createInstant, indicia, promise);
    }
}
