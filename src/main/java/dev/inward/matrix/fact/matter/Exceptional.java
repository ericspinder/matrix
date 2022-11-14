package dev.inward.matrix.fact.matter;

import dev.inward.matrix.fact.datum.Identity;

import java.util.UUID;

public interface Exceptional {

    UUID getUuid();
    Identity getTopicId();
    Indicia getIndicia();
}
