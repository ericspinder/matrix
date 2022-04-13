package dev.inward.matrix.matter;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

public class Matter<I extends Identity<I,X>,X extends Context<X>,MAT extends Matter<I,X,MAT>> implements Comparable<MAT>, Serializable {

    protected final UUID uuid;
    protected final I topicId;
    protected final Instant createInstant;
    protected final Subject subject;

    public Matter(UUID uuid, I topicId, Instant createInstant, Subject subject) {
        this.uuid = uuid;
        this.topicId = topicId;
        this.createInstant = createInstant;
        this.subject = subject;
    }
    @Override
    public int compareTo(MAT that) {
        int result = this.subject.compareTo(subject);
        if (result == 0) {
            return this.uuid.compareTo(uuid);
        }
        return result;
    }

    public final UUID getUuid() {
        return uuid;
    }
    public final I getTopicId() {
        return this.topicId;
    }
    public final Instant getCreateInstant() {
        return this.createInstant;
    }
    public final Subject getSubject() {
        return subject;
    }


}
