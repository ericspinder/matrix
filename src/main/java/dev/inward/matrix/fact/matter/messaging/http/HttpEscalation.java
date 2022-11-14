package dev.inward.matrix.fact.matter.messaging.http;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.notion.interaction.http.HttpRequest;
import dev.inward.matrix.fact.notion.interaction.http.HttpResponse;
import dev.inward.matrix.fact.matter.messaging.Escalation;
import dev.inward.matrix.fact.matter.Indicia;

import java.time.Instant;
import java.util.UUID;

public class HttpEscalation<IH extends Identity<IH,XH>, XH extends Context<XH>> extends Escalation<HttpEscalation<IH,XH>,HttpPromise<IH,XH>, HttpResponse<IH,XH>, HttpRequest<IH,XH>,IH,XH> {

    public HttpEscalation(UUID uuid, IH topicId, Instant createInstant, Indicia indicia) {
        super(uuid, topicId, createInstant, indicia);
    }
}
