package dev.inward.matrix.datum.fact.intialized.maker.http;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.interaction.http.HttpRequest;
import dev.inward.matrix.datum.fact.notion.interaction.http.HttpResponse;
import dev.inward.matrix.datum.fact.intialized.maker.Escalation;
import dev.inward.matrix.matter.Indicia;

import java.time.Instant;
import java.util.UUID;

public class HttpEscalation<IH extends Identity<IH,XH>, XH extends Context<XH>> extends Escalation<HttpEscalation<IH,XH>,HttpPromise<IH,XH>, HttpResponse<IH,XH>, HttpRequest<IH,XH>,IH,XH> {

    public HttpEscalation(UUID uuid, IH topicId, Instant createInstant, Indicia indicia) {
        super(uuid, topicId, createInstant, indicia);
    }
}
