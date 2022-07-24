package dev.inward.matrix.matter;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Context;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

public class Matter<MAT extends Matter<MAT, IMAT, XMAT>, IMAT extends Identity<IMAT, XMAT>, XMAT extends Context<XMAT>> implements Comparable<MAT>, Serializable {

    protected final UUID uuid;
    protected final IMAT topicId;
    protected final Instant createInstant;
    protected final Topic topic;

    public Matter(UUID uuid, IMAT topicId, Instant createInstant, Topic topic) {
        this.uuid = uuid;
        this.topicId = topicId;
        this.createInstant = createInstant;
        this.topic = topic;
    }
    @Override
    public int compareTo(MAT that) {
        int result = this.topic.compareTo(topic);
        if (result == 0) {
            return this.uuid.compareTo(uuid);
        }
        return result;
    }

    public final UUID getUuid() {
        return uuid;
    }
    public final IMAT getTopicId() {
        return this.topicId;
    }
    public final Instant getCreateInstant() {
        return this.createInstant;
    }
    public final Topic getSubject() {
        return topic;
    }


}
