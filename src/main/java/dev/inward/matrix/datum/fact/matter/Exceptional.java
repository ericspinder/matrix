package dev.inward.matrix.datum.fact.matter;

import dev.inward.matrix.datum.Identity;

import java.util.UUID;

public interface Exceptional {

    UUID getUuid();
    Identity getTopicId();
    Indicia getIndicia();
}
