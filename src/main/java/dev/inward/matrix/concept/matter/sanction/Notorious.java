package dev.inward.matrix.concept.matter.sanction;

import dev.inward.matrix.concept.matter.Indicia;
import dev.inward.matrix.concept.matter.messaging.Fingerprint;
import dev.inward.matrix.concept.matter.Matter;
import dev.inward.matrix.Context;

import java.time.Instant;
import java.util.UUID;

public abstract class Notorious<N extends Notorious<N,F>,F extends Fingerprint> extends Matter<N, Identity.Gate, Context.Path> {

    protected final F fingerprint;

    public Notorious(UUID uuid, Identity.Gate topicId, Instant createInstant, Indicia indicia, Identity.Gate maker, F fingerprint) {
        super(uuid,topicId,createInstant,indicia);
        this.fingerprint = fingerprint;
    }
}
