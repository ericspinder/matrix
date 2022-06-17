package dev.inward.matrix.maker;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.corpus.Corpus;
import dev.inward.matrix.matter.Matter;
import dev.inward.matrix.matter.Topic;

import java.time.Instant;
import java.util.UUID;

public abstract class Fingerprint<H extends Corpus<H,L,?>,L extends Factory<L>,F extends Fingerprint<H,L,F>> extends Matter<L, Identity.Id<L>, Context<L>,F> {

    public Fingerprint(UUID uuid, Identity.Id<L> topicId, Instant createInstant, Topic topic) {
        super(uuid, topicId, createInstant, topic);
    }
}
