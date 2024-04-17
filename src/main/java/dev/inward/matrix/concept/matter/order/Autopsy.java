package dev.inward.matrix.concept.matter.order;

import dev.inward.matrix.Identity;
import dev.inward.matrix.concept.matter.Indicia;
import dev.inward.matrix.concept.matter.Matter;
import dev.inward.matrix.Context;

import java.time.Instant;
import java.util.UUID;

public abstract class Autopsy<O extends Autopsy<O,CI,CX>,CI extends Identity<CI,CX>,CX extends Context<CX>> extends Matter<O,CI,CX> {

    public Autopsy(UUID uuid, CI containerId, Instant createInstant, Indicia indicia) {
        super(uuid, containerId, createInstant, indicia);
    }

}
