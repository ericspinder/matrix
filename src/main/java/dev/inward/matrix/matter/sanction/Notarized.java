package dev.inward.matrix.matter.sanction;
import dev.inward.matrix.path.Path;
import dev.inward.matrix.datum.Identity.SuperEgo;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.house.House;
import dev.inward.matrix.maker.Fingerprint;
import dev.inward.matrix.matter.Matter;
import dev.inward.matrix.matter.Subject;

import java.time.Instant;
import java.util.UUID;

public class Notarized<H extends House<H,?,?>,L extends Factory<L>,F extends Fingerprint<?,L,F>, M extends Notarized<H,L,F,M>> extends Matter<L, SuperEgo<H,L>, Path.Path<H,L>,M> {

    protected final F fingerprint;

    public Notarized(UUID uuid, SuperEgo<H,L> topicId, Instant createInstant, Subject subject, SuperEgo<H,?> maker, F fingerprint) {
        super(uuid, topicId, createInstant, subject, maker);
        this.fingerprint = fingerprint;
    }
}
