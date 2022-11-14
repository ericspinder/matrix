package dev.inward.matrix.fact.matter.order;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.matter.Matter;
import dev.inward.matrix.fact.matter.Indicia;

import java.time.Instant;
import java.util.UUID;

public abstract class Autopsy<O extends Autopsy<O,CI,CX>,CI extends Identity<CI,CX>,CX extends Context<CX>> extends Matter<O,CI,CX> {

    public Autopsy(UUID uuid, CI containerId, Instant createInstant, Indicia indicia) {
        super(uuid, containerId, createInstant, indicia);
    }

}
