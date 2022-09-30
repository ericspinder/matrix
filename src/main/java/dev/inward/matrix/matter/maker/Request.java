package dev.inward.matrix.matter.maker;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.matter.Matter;
import dev.inward.matrix.matter.Indicia;

import java.time.Instant;
import java.util.UUID;

public class Request<REQ extends Request<REQ,IMAT,XMAT>,IMAT extends Identity<IMAT,XMAT>,XMAT extends Context<XMAT>> extends Matter<REQ,IMAT,XMAT> {
    public Request(UUID uuid, IMAT topicId, Instant createInstant, Indicia indicia) {
        super(uuid, topicId, createInstant, indicia);
    }
}
