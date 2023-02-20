package dev.inward.matrix.fact.matter;

import dev.inward.matrix.fact.Context;
import dev.inward.matrix.fact.authoritative.Identity;

import java.util.UUID;

public interface Exceptionally<X extends Context<X>> {

    UUID getId();
    X getContext();
    Indicia getIndicia();
}
