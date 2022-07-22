package dev.inward.matrix.fact.notion.recorder.dns;

import dev.inward.matrix.agent.Edition;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.matter.Matter;
import dev.inward.matrix.matter.Topic;

import java.time.Instant;
import java.util.UUID;

public abstract class DnsMessage<E extends Edition<E>,I extends Identity<I,X>,X extends Context<X>> extends Matter<I,X,DnsMessage<E,I,X>> {

    protected final boolean reply;

    public DnsMessage(UUID uuid, I topicId, Instant createInstant, Topic topic, boolean reply,) {
        super(uuid, topicId, createInstant, topic);
    }
}
