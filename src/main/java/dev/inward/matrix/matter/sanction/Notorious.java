package dev.inward.matrix.matter.sanction;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.maker.Fingerprint;
import dev.inward.matrix.matter.Matter;

public abstract class Notorious<N extends Notorious<N,F>,F extends Fingerprint> extends Matter<N, Identity.SuperEgo, Context.Service> {

    protected final F fingerprint;

    public Notorious(UUID uuid, SuperEgo<H,L> topicId, Instant createInstant, Indicia indicia, SuperEgo<H,?> maker, F fingerprint) {
        super(uuid, topicId, createInstant, indicia, maker);
        this.fingerprint = fingerprint;
    }
}
