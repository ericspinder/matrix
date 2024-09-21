package dev.inward.matrix.concept.matter.task;

import dev.inward.matrix.concept.matter.Indicia;
import dev.inward.matrix.concept.matter.messaging.Engagement;
import dev.inward.matrix.concept.matter.messaging.Fingerprint;
import dev.inward.matrix.concept.matter.Matter;

import java.time.Instant;
import java.util.UUID;

public abstract class Request<,E extends Engagement<E,F>,F extends Fingerprint> extends Matter<> {

    protected final ;
    public Request(UUID uuid, I topicId, Instant createInstant, Indicia indicia, S sanction) {
        super(uuid, topicId, createInstant, indicia);
        this.sanction = sanction;
    }
}
