package dev.inward.matrix.maker;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.datum.fact.notion.concept.dataSupplier.Unspoken;
import dev.inward.matrix.datum.fact.notion.concept.corpus.Corpus;
import dev.inward.matrix.matter.Matter;
import dev.inward.matrix.matter.Topic;

import java.time.Instant;
import java.util.UUID;

public class Engagement<H extends Corpus<H>,L extends Factory<L>,F extends Fingerprint<F>> extends Matter<Identity.SuperEgo<H>,Engagement<H,L,F>> {

    @Unspoken
    private final F fingerprint;

    public Engagement(UUID uuid, Identity.SuperEgo<H> id, Instant createDateTime, Topic topic, F fingerprint) {
        super(uuid, id, createDateTime, topic);
        this.fingerprint = fingerprint;
    }

    public F getFingerprint() {
        return this.fingerprint;
    }
}
