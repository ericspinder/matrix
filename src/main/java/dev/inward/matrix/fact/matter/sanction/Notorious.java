package dev.inward.matrix.fact.matter.sanction;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.matter.messaging.Fingerprint;
import dev.inward.matrix.fact.matter.Indicia;
import dev.inward.matrix.fact.matter.Matter;

import java.time.Instant;
import java.util.UUID;

public abstract class Notorious<N extends Notorious<N,F>,F extends Fingerprint> extends Matter<N, Identity.SuperEgo, Context.Service> {

    protected final F fingerprint;

    public Notorious(UUID uuid, Identity.SuperEgo topicId, Instant createInstant, Indicia indicia, Identity.SuperEgo maker, F fingerprint) {
        super(uuid,topicId,createInstant,indicia);
        this.fingerprint = fingerprint;
    }
}
