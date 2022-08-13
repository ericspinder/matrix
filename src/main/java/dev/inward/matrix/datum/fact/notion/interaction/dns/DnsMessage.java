package dev.inward.matrix.datum.fact.notion.interaction.dns;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.matter.Matter;
import dev.inward.matrix.matter.Indicia;

import java.time.Instant;
import java.util.UUID;

public abstract class DnsMessage<II extends Identity<II,XI>,XI extends Context<XI>> extends Matter<DnsMessage<II,XI>,II,XI> {

    protected final boolean reply;

    public DnsMessage(UUID uuid, II topicId, Instant createInstant, Indicia indicia, boolean reply) {
        super(uuid, topicId, createInstant, indicia);
        this.reply = reply;
    }
}
