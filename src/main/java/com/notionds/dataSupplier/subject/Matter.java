package com.notionds.dataSupplier.subject;

import com.notionds.dataSupplier.datum.Id;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

public class Matter<I extends Id<I,?>,MAT extends Matter<I,MAT>> implements Comparable<MAT>, Serializable {

    private final UUID uuid;
    private final I topicId;
    private final Instant createInstant;
    private final Subject subject;

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

    public UUID getUuid() {
        return uuid;
    }
    public I getTopicId() {
        return this.topicId;
    }
    public Instant getCreateInstant() {
        return this.createInstant;
    }
    public Subject getSubject() {
        return subject;
    }

}
