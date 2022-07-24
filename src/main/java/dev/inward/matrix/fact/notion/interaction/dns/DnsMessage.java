package dev.inward.matrix.fact.notion.interaction.dns;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.matter.Matter;
import dev.inward.matrix.matter.Topic;

import java.time.Instant;
import java.util.UUID;

public abstract class DnsMessage<II extends Identity<II,XI>,XI extends Context<XI>> extends Matter<DnsMessage<II,XI>,II,XI> {

    protected final boolean reply;

    public DnsMessage(UUID uuid,II topicId, Instant createInstant, Topic topic, boolean reply) {
        super(uuid, topicId, createInstant, topic);
        this.reply = reply;
    }
}
