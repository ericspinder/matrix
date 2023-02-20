package dev.inward.matrix.fact.matter.order;

import dev.inward.matrix.fact.Specification;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.matter.Indicia;
import dev.inward.matrix.fact.authoritative.notion.Notion;
import dev.inward.matrix.fact.Context;

import java.time.Instant;
import java.util.UUID;

public abstract class Directive<D extends Directive<D,C,CI,CX>,C extends Notion<C,CI,CX,?>,CI extends Identity<CI,CX>,CX extends Context<CX>> extends Autopsy<D,C,CI,CX> {

    public Directive(UUID uuid, CI containerId, Instant createInstant, Indicia indicia, Specification specification) {
        super(uuid, containerId, createInstant, indicia, specification);
    }
}
