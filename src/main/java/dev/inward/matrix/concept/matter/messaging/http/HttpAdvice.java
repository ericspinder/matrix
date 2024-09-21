package dev.inward.matrix.concept.matter.messaging.http;

import dev.inward.matrix.concept.matter.Indicia;
import dev.inward.matrix.concept.matter.messaging.Advice;
import dev.inward.matrix.Context;

import java.time.Instant;
import java.util.UUID;

public class HttpAdvice<IH extends Identity<IH,XH>,XH extends Context<XH>> extends Advice<HttpAdvice<IH,XH>,IH,XH> {

    public HttpAdvice(UUID uuid, IH topicId, Instant createInstant, Indicia indicia) {
        super(uuid, topicId, createInstant, indicia);
    }
}
