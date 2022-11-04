package dev.inward.matrix.phenomenon;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.matter.Indicia;
import dev.inward.matrix.datum.fact.matter.order.Order;

import java.time.Instant;
import java.util.UUID;

public class SystemInitialization extends Order<SystemInitialization, Identity.Ghost, Context.Ethereal> {

    public SystemInitialization(UUID uuid, Identity.Ghost ghost, Instant createInstant, Indicia indicia) {
        super(uuid, ghost, createInstant, indicia);
    }
}
