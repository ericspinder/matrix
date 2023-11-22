package dev.inward.matrix.fact.matter;

import dev.inward.matrix.Context;
import dev.inward.matrix.Identity;
import dev.inward.matrix.Library;
import dev.inward.matrix.Scheme;

import java.util.UUID;

public interface Exceptionally {

    UUID getId();
    Context getContext();
    Indicia getIndicia();
}
