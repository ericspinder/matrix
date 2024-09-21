package dev.inward.matrix.concept.matter.report;

import dev.inward.matrix.Terrene;
import dev.inward.matrix.Context;

import java.time.Instant;
import java.util.Map;

public class Haunting extends Report<Haunting, Identity.Ghost, Context.Ethereal> {

    public Haunting(Identity.Ghost ghost, Identity.Ghost containerId, Instant createInstant, String locus, Terrene terrene, Map<String, Object> details) {
        super(ghost, containerId, createInstant, locus, terrene, details);
    }
}
