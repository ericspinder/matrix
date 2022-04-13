package dev.inward.matrix.matter.task;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.matter.Matter;
import dev.inward.matrix.matter.Subject;
import dev.inward.matrix.matter.sanction.Sanction;

import java.time.Instant;
import java.util.UUID;

public abstract class Request<I extends Identity<I,X>,X extends Context<X>,S extends Sanction,Q extends Request<I,X,S,Q>> extends Matter<I,X,Q> {

    protected final S sanction;
    public Request(UUID uuid, I topicId, Instant createInstant, Subject subject,S sanction) {
        super(uuid, topicId, createInstant, subject);
        this.sanction = sanction;
    }
}
