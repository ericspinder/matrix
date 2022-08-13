package dev.inward.matrix.matter;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

public class Matter<MAT extends Matter<MAT, IMAT, XMAT>, IMAT extends Identity<IMAT, XMAT>, XMAT extends Context<XMAT>> implements Comparable<MAT>, Serializable {

    protected final UUID uuid;
    protected final IMAT topicId;
    protected final Instant createInstant;
    protected final Indicia indicia;

    public Matter(UUID uuid, IMAT topicId, Instant createInstant, Indicia indicia) {
        this.uuid = uuid;
        this.topicId = topicId;
        this.createInstant = createInstant;
        this.indicia = indicia;
    }
    @Override
    public int compareTo(MAT that) {
        int result = this.indicia.compareTo(indicia);
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
    public final Indicia getSubject() {
        return indicia;
    }


}
