package com.notionds.dataSupplier.subject;

import com.notionds.dataSupplier.datum.Id;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

public class Matter<I extends Id<?,?,I,?>,MAT extends Matter<I,MAT>> implements Comparable<MAT>, Serializable {

    private final UUID uuid;
    private final I subjectId;
    /**
     * Default time zone is set in the Fact or Notion
     */
    private final LocalDateTime createDateTime;
    private final Subject subject;
    public Matter(UUID uuid, I subjectId, LocalDateTime createDateTime, Subject subject) {
        this.uuid = uuid;
        this.subjectId = subjectId;
        this.createDateTime = createDateTime;
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
    public I getSubjectId() {
        return this.subjectId;
    }

    public final LocalDateTime getCreateDateTime() {
        return this.createDateTime;
    }
    public Subject getSubject() {
        return subject;
    }

}
