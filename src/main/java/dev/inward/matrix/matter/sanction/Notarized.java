package dev.inward.matrix.matter.sanction;

import dev.inward.matrix.datum.Identity.SuperEgo;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.datum.fact.notion.concept.corpus.Corpus;
import dev.inward.matrix.maker.Fingerprint;
import dev.inward.matrix.matter.Matter;
import dev.inward.matrix.matter.Topic;
import dev.inward.matrix.path.Path;

import java.time.Instant;
import java.util.UUID;

public class Notarized<H extends Corpus<H,?,?>,L extends Factory<L>,F extends Fingerprint<?,L,F>, M extends Notarized<H,L,F,M>> extends Matter<L, SuperEgo<H,L>, Path.Path<H,L>,M> {

    protected final F fingerprint;

    public Notarized(UUID uuid, SuperEgo<H,L> topicId, Instant createInstant, Topic topic, SuperEgo<H,?> maker, F fingerprint) {
        super(uuid, topicId, createInstant, topic, maker);
        this.fingerprint = fingerprint;
    }
}
