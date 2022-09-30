package dev.inward.matrix.matter.order;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.Specification;
import dev.inward.matrix.matter.Matter;
import dev.inward.matrix.matter.Indicia;

import java.time.Instant;
import java.util.UUID;

public abstract class Order<O extends Order<O,C,CI,CX>,C extends Fact<C,CI,CX,?,?,?>,CI extends Identity<CI,CX>,CX extends Context<CX>> extends Matter<O,CI,CX> {

    protected final Specification<C,CI,CX> specification;

    public Order(UUID uuid, CI containerId, Instant createInstant, Indicia indicia, Specification specification) {
        super(uuid, containerId, createInstant, indicia);
        this.specification = specification;
    }

}
