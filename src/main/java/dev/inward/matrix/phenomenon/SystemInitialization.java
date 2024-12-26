package dev.inward.matrix.phenomenon;

import dev.inward.matrix.Context;
import dev.inward.matrix.log.Indicia;
import dev.inward.matrix.concept.matter.order.Autopsy;

import java.time.Instant;
import java.util.UUID;

public class SystemInitialization extends Autopsy<SystemInitialization, Identity.Ghost, Context.Ethereal> {

    public SystemInitialization(UUID uuid, Identity.Ghost ghost, Instant createInstant, Indicia indicia) {
        super(uuid, ghost, createInstant, indicia);
    }
}
