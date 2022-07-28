package dev.inward.matrix.matter;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Context;

import java.time.Instant;
import java.util.UUID;

public class Request<REQ extends Request<REQ,IMAT,XMAT>,IMAT extends Identity<IMAT,XMAT>,XMAT extends Context<XMAT>> extends Matter<REQ,IMAT,XMAT> {
    public Request(UUID uuid, IMAT topicId, Instant createInstant, Topic topic) {
        super(uuid, topicId, createInstant, topic);
    }
}
