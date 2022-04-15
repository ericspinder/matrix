package dev.inward.matrix.datum.fact.notion.concept;

import dev.inward.matrix.datum.Identity;

import java.util.UUID;

public interface Referenced<X extends Context.Platform<X>> {

    UUID getUuid();
}
