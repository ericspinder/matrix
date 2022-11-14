package dev.inward.matrix.fact.matter.messaging.http;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.matter.messaging.Advice;
import dev.inward.matrix.fact.matter.Indicia;

import java.time.Instant;
import java.util.UUID;

public class HttpAdvice<IH extends Identity<IH,XH>,XH extends Context<XH>> extends Advice<HttpAdvice<IH,XH>,IH,XH> {

    public HttpAdvice(UUID uuid, IH topicId, Instant createInstant, Indicia indicia) {
        super(uuid, topicId, createInstant, indicia);
    }
}
