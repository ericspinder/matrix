package dev.inward.matrix.datum.fact.intialized.maker.http;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.intialized.maker.Advice;
import dev.inward.matrix.matter.Indicia;

import java.time.Instant;
import java.util.UUID;

public class HttpAdvice<IH extends Identity<IH,XH>,XH extends Context<XH>> extends Advice<HttpAdvice<IH,XH>,IH,XH> {

    public HttpAdvice(UUID uuid, IH topicId, Instant createInstant, Indicia indicia) {
        super(uuid, topicId, createInstant, indicia);
    }
}
