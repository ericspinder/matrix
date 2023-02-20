package dev.inward.matrix.phenomenon;

import dev.inward.matrix.fact.authoritative.Governance;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.matter.Indicia;
import dev.inward.matrix.fact.matter.order.Autopsy;

import java.time.Instant;
import java.util.UUID;

public class SystemInitialization extends Autopsy<SystemInitialization, Identity.Ghost, Governance.Ethereal> {

    public SystemInitialization(UUID uuid, Identity.Ghost ghost, Instant createInstant, Indicia indicia) {
        super(uuid, ghost, createInstant, indicia);
    }
}
