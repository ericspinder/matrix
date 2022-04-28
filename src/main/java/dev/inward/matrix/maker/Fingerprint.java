package dev.inward.matrix.maker;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.house.House;
import dev.inward.matrix.matter.Matter;
import dev.inward.matrix.matter.Subject;

import java.time.Instant;
import java.util.UUID;

public abstract class Fingerprint<H extends House<H,L,?>,L extends Factory<L>,F extends Fingerprint<H,L,F>> extends Matter<L, Identity.Id<L>, Context<L>,F> {

    public Fingerprint(UUID uuid, Identity.Id<L> topicId, Instant createInstant, Subject subject) {
        super(uuid, topicId, createInstant, subject);
    }
}
