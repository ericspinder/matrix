package dev.inward.matrix.matter.order;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.Specification;
import dev.inward.matrix.domain.Authority;
import dev.inward.matrix.matter.Matter;
import dev.inward.matrix.matter.Indicia;

import java.time.Instant;
import java.util.UUID;

public abstract class Order<O extends Order<O,CI,CX>,CI extends Identity.Id<CI,CX>,CX extends Context.Platform<CX>> extends Matter<O,CI,CX> {

    protected final Authority authority;
    public Order(UUID uuid, CI containerId, Instant createInstant, Indicia indicia) {
        super(uuid, containerId, createInstant, indicia);
    }

}
