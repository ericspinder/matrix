package dev.inward.matrix.maker;

import dev.inward.matrix.datum.fact.notion.concept.dataSupplier.Unspoken;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.house.House;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.matter.Matter;
import dev.inward.matrix.matter.Subject;

import java.time.Instant;
import java.util.UUID;

public class Engagement<H extends House<H>,L extends Factory<L>,F extends Fingerprint<F>> extends Matter<Identity.SuperEgo<H>,Engagement<H,L,F>> {

    @Unspoken
    private final F fingerprint;

    public Engagement(UUID uuid, Identity.SuperEgo<H> id, Instant createDateTime, Subject subject, F fingerprint) {
        super(uuid, id, createDateTime, subject);
        this.fingerprint = fingerprint;
    }

    public F getFingerprint() {
        return this.fingerprint;
    }
}
