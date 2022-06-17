package dev.inward.matrix.matter;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;

import java.time.Duration;
import java.time.Instant;
import java.util.UUID;

public abstract class Promise<I extends Identity<I,X>,X extends Context<X>,P extends Promise<I,X,P>> extends Matter<I,X,P> {

    private Instant instantReady;
    private Duration durationAvailable;
    public Promise(UUID uuid, I topicId, Instant createInstant, Topic topic) {
        super(uuid,topicId,createInstant, topic);
    }
}
