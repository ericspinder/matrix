package dev.inward.matrix.matter.maker;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.matter.Matter;
import dev.inward.matrix.matter.Indicia;

import java.time.Instant;
import java.util.UUID;

public class Engagement<E extends Engagement<E,F>,F extends Fingerprint> extends Matter<Engagement<E,F>,Identity.Ego, Context.Demarc> {

    private final F fingerprint;

    public Engagement(UUID uuid, Identity.Ego id, Instant createDateTime, Indicia indicia, F fingerprint) {
        super(uuid, id, createDateTime, indicia);
        this.fingerprint = fingerprint;
    }

    public F getFingerprint() {
        return this.fingerprint;
    }
}
