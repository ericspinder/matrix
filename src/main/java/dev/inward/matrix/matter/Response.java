package dev.inward.matrix.matter;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Context;

import java.time.Instant;
import java.util.UUID;

public class Response<RESP extends Response<RESP,IMAT,XMAT>,IMAT extends Identity<IMAT,XMAT>,XMAT extends Context<XMAT>> extends Matter<RESP,IMAT,XMAT> {
    public Response(UUID uuid, IMAT topicId, Instant createInstant, Topic topic) {
        super(uuid, topicId, createInstant, topic);
    }
}
