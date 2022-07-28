package dev.inward.matrix.fact.intialized.maker.http;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.notion.interaction.http.HttpRequest;
import dev.inward.matrix.fact.notion.interaction.http.HttpResponse;
import dev.inward.matrix.matter.Escalation;
import dev.inward.matrix.matter.Topic;

import java.time.Instant;
import java.util.UUID;

public class HttpEscalation<IH extends Identity<IH,XH>, XH extends Context<XH>> extends Escalation<HttpEscalation<IH,XH>,HttpPromise<IH,XH>, HttpResponse<IH,XH>, HttpRequest<IH,XH>,IH,XH> {

    public HttpEscalation(UUID uuid, IH topicId, Instant createInstant, Topic topic) {
        super(uuid, topicId, createInstant, topic);
    }
}
