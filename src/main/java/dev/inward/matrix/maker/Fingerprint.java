package dev.inward.matrix.maker;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.matter.Matter;
import dev.inward.matrix.matter.Topic;
import dev.inward.matrix.path.Path;

import java.time.Instant;
import java.util.UUID;

public class Fingerprint<X extends Path<X>> extends Matter<Identity.Id<X>,X,Fingerprint<X>> {


    public Fingerprint(UUID uuid, Identity.Id<X> topicId, Instant createInstant, Topic topic) {
        super(uuid, topicId, createInstant, topic);
    }
}
